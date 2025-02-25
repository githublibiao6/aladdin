package com.aladdin.mis.socket.handles;
/*
 *  Created by cles on 2025/2/17 23:06
 */

import com.aladdin.mis.chat.param.ChatMessageParam;
import com.aladdin.mis.chat.service.ChatRecordService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 消息处理
 * @author cles
 * @description:
 * @Date 2025/2/17 23:06
 * @version: 1.0.0
 */
@Component
@Slf4j
public class InfoHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoHandler.class);

    @Autowired
    private ChatRecordService chatRecordService;

    public boolean handle(String info){
        try{
            ChatMessageParam param = JSONObject.parseObject(info, ChatMessageParam.class);
            System.out.println(JSONObject.toJSONString(param));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
