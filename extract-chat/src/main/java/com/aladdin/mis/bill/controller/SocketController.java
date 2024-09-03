package com.aladdin.mis.bill.controller;

import com.aladdin.mis.bill.config.WebSocketSessionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
* @Description: socket 连接
* @Param: https://blog.51cto.com/u_15049782/4707502 单机多连接
* @return:
* @Author: cles
* @Date: 2020/4/17 23:47
*/
@ServerEndpoint("/socket/{id}/{name}")
@RestController
public class SocketController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketController.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("id") Integer id, @PathParam("name") String name) {
        WebSocketSessionConfig.setSession(id, session);
        WebSocketSessionConfig.sendMessage(id, "服务器发送");
        LOGGER.info("Open a websocket. id={}, name={}", id, name);
    }

    @OnClose
    public void onClose(@PathParam("id") Integer id) {
        WebSocketSessionConfig.removeSession(id);
        LOGGER.info("Close a websocket. ");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        Integer toUserId = 2;
        LOGGER.info("toUserId: " + toUserId);
        LOGGER.info("Receive a message from client: " + message);
        LOGGER.info("session id: " + session.getId());
        WebSocketSessionConfig.sendMessage(toUserId , message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.error("Error while websocket. ", error);
    }

    public int getOnlineCount() {
        return WebSocketSessionConfig.getSessionCount();
    }

}
