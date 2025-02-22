package com.aladdin.mis.socket.config;
/*
 *  Created by cles on 2025/2/17 23:07
 */

import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cles
 * @description:
 * @Date 2025/2/17 23:07
 * @version: 1.0.0
 */
public class NettyConfig {

    /**
     * 存储接入的客户端的channel对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 存储接入的客户端的channel对象
     */
    public static Map<ChannelId, String> userMap = new HashMap<>(16);



}
