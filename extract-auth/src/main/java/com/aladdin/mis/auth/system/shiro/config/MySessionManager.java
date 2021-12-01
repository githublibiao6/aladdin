package com.aladdin.mis.auth.system.shiro.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @Description
 * @Project aj-parent
 * @PageName  net.sinorock.aj.modules.base.core.security.shiro
 * @ClassName MySessionManager
 * @author MengyuWu
 * @date 2019-8-2616:08
 */
@Configuration
@Slf4j
public class MySessionManager extends DefaultWebSessionManager {

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {

        super();
    }


    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader("Authorization");
        //如果请求头中有 Authorization （前端请求头中设置的名字）则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            Serializable m = super.getSessionId(request, response);
            return m;
        }
    }


}
