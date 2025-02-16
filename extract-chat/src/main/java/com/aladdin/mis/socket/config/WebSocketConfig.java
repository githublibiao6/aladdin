package com.aladdin.mis.socket.config;

import org.springframework.context.annotation.Configuration;

/**
 * 首先注入一个ServerEndpointExporterBean,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
 * 链接：https://www.imooc.com/article/70702?block_id=tuijian
 * @author cles
 */
@Configuration
public class WebSocketConfig {

    /**
     * 首先注入一个ServerEndpointExporterBean,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
     * @return
     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
}
