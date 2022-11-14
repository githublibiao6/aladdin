package com.aladdin.mis.auth.shiro.config;
/*
 *  Created by cles on 2022/1/14 21:51
 */


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author cles
 * @description: 自定义生成sessionId
 * @Date 2022/1/14 21:51
 * @version: 1.0.0
 */
public class OmSessionIdGenerator implements SessionIdGenerator {

    @Override
    public Serializable generateId(Session session) {
        String sessionId = UUID.randomUUID().toString().replace("-","");
        return "om"+ sessionId;
    }
}
