package com.aladdin.common.security.redis.util;

import com.aladdin.common.security.redis.config.JedisConfig;
import com.alibaba.fastjson2.JSONArray;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class RedisUtil {

    public static boolean setString(String key, String value) {
        if (!JedisConfig.getEnableRedis()) {
            return true;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            String res = jedis.set(key, value);
            return "OK".equals(res);
        }
    }

    public static boolean setString(String key, int seconds, String value) {
        if (!JedisConfig.getEnableRedis()) {
            return true;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            String res = jedis.setex(key, seconds, value);
            return "OK".equals(res);
        }
    }

    public static String getString(String key) {
        if (!JedisConfig.getEnableRedis()) {
            return "";
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            return jedis.get(key);
        }
    }

    public static <T> boolean setList(String key, List<T> list) {
        if (!JedisConfig.getEnableRedis()) {
            return true;
        }
        JSONArray arr = new JSONArray();
        arr.addAll(list);
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            String res = jedis.set(key, arr.toJSONString());
            return "OK".equals(res);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getList(String key) {
        if (!JedisConfig.getEnableRedis()) {
            return null;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            String str = jedis.get(key);
            JSONArray arr = (JSONArray) JSONArray.parseArray(str);
            List<T> list = new ArrayList<>();
            arr.forEach(t -> list.add((T) t));
            return list;
        }
    }

    public static <T> boolean setObject(String key, T o) {
        if (!JedisConfig.getEnableRedis()) {
            return true;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            String res = jedis.set(key, o.toString());
            return "OK".equals(res);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObject(String key) {
        if (!JedisConfig.getEnableRedis()) {
            return null;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            return (T) jedis.get(key);
        }
    }

    public static boolean removeString(String key) {
        if (!JedisConfig.getEnableRedis()) {
            return true;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            jedis.del(key);
            return true;
        }
    }

    public static Long pushList(String key, String... values) {
        if (!JedisConfig.getEnableRedis()) {
            return 0L;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            return jedis.lpush(key, values);
        }
    }

    public static List<String> rangeList(String key, long start, long end) {
        if (!JedisConfig.getEnableRedis()) {
            return new ArrayList<>();
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            return jedis.lrange(key, start, end);
        }
    }

    public static Long trimList(String key, long start, long end) {
        if (!JedisConfig.getEnableRedis()) {
            return 0L;
        }
        try (Jedis jedis = JedisConfig.getJedis(0)) {
            jedis.ltrim(key, start, end);
            return jedis.llen(key);
        }
    }
}
