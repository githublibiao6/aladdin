package com.aladdin.common.core.cache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 系统配置缓存服务
 *
 * @author cles
 * @date 2026/05/06
 */
@Component
public class SysConfigCacheService {

    private static final String CONFIG_PREFIX = "sys:config:";

    private final StringRedisTemplate redisTemplate;

    public SysConfigCacheService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setConfig(String key, String value) {
        redisTemplate.opsForValue().set(CONFIG_PREFIX + key, value);
    }

    public void setConfig(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(CONFIG_PREFIX + key, value, timeout, unit);
    }

    public String getConfig(String key) {
        return redisTemplate.opsForValue().get(CONFIG_PREFIX + key);
    }

    public String getConfig(String key, String defaultValue) {
        String value = getConfig(key);
        return value != null ? value : defaultValue;
    }

    public Boolean getConfigAsBoolean(String key) {
        String value = getConfig(key);
        return value != null && Boolean.parseBoolean(value);
    }

    public Integer getConfigAsInt(String key) {
        String value = getConfig(key);
        return value != null ? Integer.parseInt(value) : null;
    }

    public void removeConfig(String key) {
        redisTemplate.delete(CONFIG_PREFIX + key);
    }

    public void clearAll() {
        Set<String> keys = redisTemplate.keys(CONFIG_PREFIX + "*");
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }
}
