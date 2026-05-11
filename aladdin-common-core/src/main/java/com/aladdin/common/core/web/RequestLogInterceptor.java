package com.aladdin.common.core.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 请求日志拦截器
 *
 * @author cles
 * @date 2026/05/06
 */
public class RequestLogInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestLogInterceptor.class);

    private static final String START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = MDC.get("traceId");
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String clientIp = getClientIp(request);

        log.info("[{}] >>> {} {} {} ip={}", traceId, method, uri,
                queryString != null ? "?" + queryString : "", clientIp);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        String traceId = MDC.get("traceId");
        long startTime = (Long) request.getAttribute(START_TIME);
        long duration = System.currentTimeMillis() - startTime;
        int status = response.getStatus();

        if (ex != null) {
            log.error("[{}] <<< {} {} error={} duration={}ms", traceId,
                    request.getMethod(), request.getRequestURI(), ex.getMessage(), duration);
        } else {
            log.info("[{}] <<< {} {} status={} duration={}ms", traceId,
                    request.getMethod(), request.getRequestURI(), status, duration);
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}
