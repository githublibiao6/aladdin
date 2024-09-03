package com.aladdin.mis.bill.config;

import org.springframework.context.annotation.Configuration;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 首先注入一个ServerEndpointExporterBean,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
 * 链接：https://www.imooc.com/article/70702?block_id=tuijian
 * @author cles
 */
@Configuration
public class WebSocketSessionConfig {


    private static ConcurrentHashMap<Integer , Session> map = new ConcurrentHashMap<>();

    /**
     * 获取session
     * @return
     */
    public static Integer getSessionCount(){
        if(map == null || map.isEmpty()){
            return 0;
        }
        return map.size();
    }

    /**
     * 获取session
     * @param id
     * @return
     */
    public static Session getSession(Integer id){
        return map.get(id);
    }

    /**
     * 设置session
     * @param id
     * @return
     */
    public static void setSession(Integer id, Session session){
        map.put(id, session);
    }

    /**
     * 设置session
     * @param id
     * @return
     */
    public static void removeSession(Integer id){
        Session session = getSession(id);
        if(session == null){
            return;
        }
        if (session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                System.out.println("session关闭异常");
            }
        }
        map.remove(id);
    }

    public static void sendMessage(Integer id, String message) {
        Session session = getSession(id);
        if (session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                System.out.println("发送消息异常");
            }
        }
    }
}
