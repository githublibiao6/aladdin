package com.aladdin.common.core.web;

import com.aladdin.common.core.annotation.RateLimit;
import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.core.utils.IpUtil;
import com.aladdin.common.core.utils.SpringContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * 接口限流切面
 *
 * @author cles
 * @date 2026/05/06
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "aladdin.core.rate-limit", name = "enabled", havingValue = "true", matchIfMissing = true)
public class RateLimitAspect {

    private static final Logger log = LoggerFactory.getLogger(RateLimitAspect.class);

    private static final String LIMIT_KEY_PREFIX = "rate_limit:";

    private static final String LUA_SCRIPT =
            "local count = redis.call('get', KEYS[1]) " +
            "if count and tonumber(count) > tonumber(ARGV[1]) then " +
            "  return tonumber(count) " +
            "end " +
            "redis.call('incr', KEYS[1]) " +
            "if tonumber(redis.call('get', KEYS[1])) == 1 then " +
            "  redis.call('expire', KEYS[1], ARGV[2]) " +
            "end " +
            "return tonumber(redis.call('get', KEYS[1]))";

    @Before("@annotation(rateLimit)")
    public void before(JoinPoint joinPoint, RateLimit rateLimit) {
        String key = buildKey(joinPoint, rateLimit);
        StringRedisTemplate redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
        DefaultRedisScript<Long> script = new DefaultRedisScript<>(LUA_SCRIPT, Long.class);
        Long result = redisTemplate.execute(script,
                Collections.singletonList(key),
                String.valueOf(rateLimit.count()),
                String.valueOf(rateLimit.period()));
        if (result != null && result > rateLimit.count()) {
            log.warn("接口限流: key={}, count={}", key, result);
            throw new BusinessException(GlobalErrorCode.TOO_MANY_REQUESTS, rateLimit.message());
        }
    }

    private String buildKey(JoinPoint joinPoint, RateLimit rateLimit) {
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        String identifier;
        switch (rateLimit.limitType()) {
            case IP:
                HttpServletRequest request = getCurrentRequest();
                identifier = request != null ? IpUtil.getIpAddr(request) : "unknown";
                break;
            case USER:
                identifier = getCurrentUserId();
                break;
            default:
                identifier = "global";
                break;
        }
        return LIMIT_KEY_PREFIX + method + ":" + identifier;
    }

    private HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }

    private String getCurrentUserId() {
        try {
            Object request = getCurrentRequest();
            if (request != null) {
                Object userId = ((HttpServletRequest) request).getAttribute("userId");
                if (userId != null) {
                    return userId.toString();
                }
            }
            return "anonymous";
        } catch (Exception e) {
            return "anonymous";
        }
    }
}
