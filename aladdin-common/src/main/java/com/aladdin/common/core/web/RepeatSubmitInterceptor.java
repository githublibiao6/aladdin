package com.aladdin.common.core.web;

import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.core.utils.JsonUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 重复提交拦截器
 *
 * @author cles
 * @date 2026/04/30
 */
public class RepeatSubmitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
