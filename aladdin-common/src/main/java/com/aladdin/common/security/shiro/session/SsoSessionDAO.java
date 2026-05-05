package com.aladdin.common.security.shiro.session;

import com.aladdin.common.security.redis.util.RedisUtil;
import com.alibaba.fastjson2.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class SsoSessionDAO extends AbstractSessionDAO {

    private static final String SESSION_PREFIX = "sso:session:";
    private static final int SESSION_EXPIRE_SECONDS = 1800;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        storeSession(sessionId, session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        String key = SESSION_PREFIX + sessionId.toString();
        String value = RedisUtil.getString(key);
        if (value == null || value.isEmpty()) {
            return null;
        }
        return JSON.parseObject(value, SimpleSession.class);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            return;
        }
        storeSession(session.getId(), session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        String key = SESSION_PREFIX + session.getId().toString();
        RedisUtil.removeString(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return Collections.emptyList();
    }

    private void storeSession(Serializable sessionId, Session session) {
        if (sessionId == null || session == null) {
            return;
        }
        String key = SESSION_PREFIX + sessionId.toString();
        String value = JSON.toJSONString(session);
        RedisUtil.setString(key, SESSION_EXPIRE_SECONDS, value);
    }

    @Override
    protected Serializable generateSessionId(Session session) {
        return "om" + UUID.randomUUID().toString().replace("-", "");
    }
}
