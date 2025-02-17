package com.aladdin.mis.socket.config;

import com.aladdin.mis.socket.handles.WebSocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * 链接：https://blog.csdn.net/qq_33375499/article/details/135149782
 * @author cles
 */
@Slf4j
@Configuration
public class WebSocketConfig implements CommandLineRunner {

    private static final Integer PORT = 8888;

    @Override
    public void run(String... args) throws Exception {
        new WebSocketConfig().start();
    }

    public void start() {
        // 创建EventLoopGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new HttpServerCodec());
                            // 最大数据长度
                            pipeline.addLast(new HttpObjectAggregator(65536));
                            // 添加接收websocket请求的url匹配路径
                            pipeline.addLast(new WebSocketServerProtocolHandler("/websocket"));
                            // 10秒内收不到消息强制断开连接
                            // pipeline.addLast(new ReadTimeoutHandler(10, TimeUnit.SECONDS));
                            pipeline.addLast(new WebSocketHandler());
                        }
                    });

            ChannelFuture future = serverBootstrap.bind(PORT).sync();
            log.info("websocket server started, port={}", PORT);
            // 处理 channel 的关闭，sync 方法作用是同步等待 channel 关闭
            // 阻塞
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("websocket server exception", e);
            throw new RuntimeException(e);
        } finally {
            log.info("websocket server close");
            // 关闭EventLoopGroup
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
