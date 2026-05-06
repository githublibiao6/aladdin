package com.aladdin.common.core.web;

import com.aladdin.common.core.config.CoreProperties;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.core.utils.JsonUtil;
import com.aladdin.common.core.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 防重提交拦截器
 *
 * @author cles
 * @date 2026/05/06
 */
public class RepeatSubmitInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RepeatSubmitInterceptor.class);

    private static final String REPEAT_KEY_PREFIX = "repeat_submit:";
    private static final String HEADER_TOKEN = "X-Submit-Token";

    private CoreProperties coreProperties;

    public RepeatSubmitInterceptor(CoreProperties coreProperties) {
        this.coreProperties = coreProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!coreProperties.isRepeatSubmitEnabled()) {
            return true;
        }
        if (!"POST".equalsIgnoreCase(request.getMethod())
                && !"PUT".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String submitToken = request.getHeader(HEADER_TOKEN);
        if (StringUtils.hasText(submitToken)) {
            StringRedisTemplate redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
            String redisKey = REPEAT_KEY_PREFIX + submitToken;
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(redisKey, "1",
                    coreProperties.getRepeatSubmitInterval(), TimeUnit.MILLISECONDS);
            if (absent == null || !absent) {
                log.warn("重复提交拦截: uri={}, token={}", request.getRequestURI(), submitToken);
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(JsonUtil.toJson(com.aladdin.common.core.domain.R.fail(GlobalErrorCode.REPEAT_SUBMIT)));
                return false;
            }
        }
        return true;
    }
}
