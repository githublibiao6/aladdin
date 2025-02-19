package com.aladdin.mis.socket.config;
/*
 *  Created by cles on 2025/2/17 23:07
 */

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

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



}
