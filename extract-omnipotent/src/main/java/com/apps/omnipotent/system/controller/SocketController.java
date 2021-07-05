package com.apps.omnipotent.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
* @Description: socket 连接
* @Param:
* @return:
* @Author: cles
* @Date: 2020/4/17 23:47
*/
@ServerEndpoint("/socket/{id}/{name}")
@RestController
public class SocketController {

        // 用来记录当前连接数的变量
        private static volatile int onlineCount = 0;

        // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
//        private static CopyOnWriteArraySet<SocketController> webSocketSet = new CopyOnWriteArraySet<SocketController>();
        private static ConcurrentHashMap<Long ,SocketController> webSocketSet = new ConcurrentHashMap<Long,SocketController>();

        // 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
        private Session session;

        private static final Logger LOGGER = LoggerFactory.getLogger(SocketController.class);

        @OnOpen
        public void onOpen(Session session, @PathParam("id") long id, @PathParam("name") String name) throws Exception {
            this.session = session;
            System.out.println(this.session.getId());
            webSocketSet.put(id,this);
            LOGGER.info("Open a websocket. id={}, name={}", id, name);
            this.sendMessage("服务器发送");
        }

        @OnClose
        public void onClose() {
            webSocketSet.remove(this);
            LOGGER.info("Close a websocket. ");
        }

        @OnMessage
        public void onMessage(String message, Session session) throws Exception {
            LOGGER.info("Receive a message from client: " + message);
            if("1".equals(session.getId())){
                webSocketSet.get(1l).sendMessage(message);
            }else {
                webSocketSet.get(2l).sendMessage(message);
            }
        }

        @OnError
        public void onError(Session session, Throwable error) {
            LOGGER.error("Error while websocket. ", error);
        }

        public void sendMessage(String message) throws Exception {
            if (this.session.isOpen()) {
                this.session.getBasicRemote().sendText(message);
            }
        }

        public static synchronized int getOnlineCount() {
            return onlineCount;
        }

        public static synchronized void addOnlineCount() {
            SocketController.onlineCount++;
        }

        public static synchronized void subOnlineCount() {
            SocketController.onlineCount--;
        }
}
