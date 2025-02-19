package com.aladdin.mis.socket.handles;
/*
 *  Created by cles on 2025/2/17 23:06
 */

import com.aladdin.mis.socket.config.NettyConfig;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author cles
 * @description:
 * @Date 2025/2/17 23:06
 * @version: 1.0.0
 */
@Slf4j
@Component
public class WebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private static InfoHandler infoHandler;

    private WebSocketServerHandshaker webSocketServerHandshaker;
    private static final String WEB_SOCKET_URL = "ws://127.0.0.1:8888/websocket";

    @Autowired
    public void setInfoHandler(InfoHandler infoHandler) {
        WebSocketHandler.infoHandler = infoHandler;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 创建连接时执行
        NettyConfig.group.add(ctx.channel());
        // todo 保存连接日志 连接id和用户的关系
        log.info("client channel active, id={}", ctx.channel().id().toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 关闭连接时执行
        NettyConfig.group.remove(ctx.channel());
        log.info("client channel disconnected, id={}", ctx.channel().id().toString());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 服务端接收客户端发送过来的数据结束之后调用
        ctx.flush();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            WebSocketServerProtocolHandler.HandshakeComplete handshake = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
            log.info("client channel connected, id={}, url={}", ctx.channel().id().toString(), handshake.requestUri());
        }
    }

    /**
     * 接收消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg" +msg);
        if (msg instanceof FullHttpRequest) {
            // 处理客户端http握手请求
            handlerHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            // 处理websocket连接业务
            handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
        //接收msg消息{与上一章节netty04相比，此处已经不需要自己进行解码}
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
//        //通知客户端链消息发送成功
//        String str = "服务端收到：" + new Date() + " " + msg + "\r\n";
//        ByteBuf buf = Unpooled.buffer(str.getBytes().length);
//        buf.writeBytes(str.getBytes("GBK"));
//        ctx.writeAndFlush(buf);
//        System.out.println("-----------------------------------------");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg" +msg);
        if (msg instanceof FullHttpRequest) {
            // 处理客户端http握手请求
            handlerHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            // 处理websocket连接业务
            handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    /**
     * 处理websocket连接业务
     *
     * @param ctx
     * @param frame
     */
    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        log.info("handlerWebSocketFrame>>>>class={}", frame.getClass().getName());
        // 判断是否是关闭websocket的指令
        if (frame instanceof CloseWebSocketFrame) {
            webSocketServerHandshaker.close(ctx.channel(), ((CloseWebSocketFrame) frame).retain());
            return;
        }
        // 判断是否是ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new RuntimeException("不支持消息类型：" + frame.getClass().getName());
        }
        String text = ((TextWebSocketFrame) frame).text();
        if ("ping".equals(text)) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        log.info("WebSocket message received: {}", text);
        infoHandler.handle(text);
        /**
         * 可通过客户传输的text，设计处理策略：
         * 如：text={"type": "messageHandler", "userId": "111"}
         * 服务端根据type，采用策略模式，自行派发处理
         *
         * 注意：这里不需要使用线程池，因为Netty 采用 Reactor线程模型（目前使用的是主从Reactor模型），
         * Handler已经是线程处理，每个用户的请求是线程隔离的
         */
        // 返回WebSocket响应
        System.out.println(ctx.channel().id());
        // 返回浏览器端消息
//        ctx.writeAndFlush(new TextWebSocketFrame("server return:" + text));
        /* 群发 这里的群发是可以给所有人发
        TextWebSocketFrame twsf = new TextWebSocketFrame(new Date().toString()
                + ctx.channel().id()
                + " : "
                + text);
        NettyConfig.group.writeAndFlush(twsf);*/
    }

    /**
     * 处理客户端http握手请求
     *
     * @param ctx
     * @param request
     */
    private void handlerHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        log.info("handlerHttpRequest>>>>class={}", request.getClass().getName());
        // 判断是否采用WebSocket协议
        if (!request.getDecoderResult().isSuccess() || !("websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(WEB_SOCKET_URL, null, false);
        webSocketServerHandshaker = wsFactory.newHandshaker(request);
        if (webSocketServerHandshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            webSocketServerHandshaker.handshake(ctx.channel(), request);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, DefaultFullHttpResponse response) {
        if (response.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(response.getStatus().toString(), StandardCharsets.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
        }
        // 服务端向客户端发送数据
        ChannelFuture f = ctx.channel().writeAndFlush(response);
        if (response.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 非正常断开时调用
        log.error("client channel execute exception, id={}", ctx.channel().id().toString(), cause);
        ctx.close();
    }
}
