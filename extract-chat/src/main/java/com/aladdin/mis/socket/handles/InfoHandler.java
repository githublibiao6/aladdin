package com.aladdin.mis.socket.handles;
/*
 *  Created by cles on 2025/2/17 23:06
 */

import com.aladdin.mis.chat.param.ChatMessageParam;
import com.aladdin.mis.chat.service.ChatRecordService;
import com.aladdin.mis.socket.config.NettyConfig;
import com.alibaba.fastjson.JSONObject;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/** 消息处理
 * @author cles
 * @description:
 * @Date 2025/2/17 23:06
 * @version: 1.0.0
 */
@Slf4j
@Component
public class InfoHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoHandler.class);

    @Autowired
    private ChatRecordService chatRecordService;

    public boolean getInfo(String info){
        ChatMessageParam param = JSONObject.parseObject(info, ChatMessageParam.class);
        return true;
    }
}
