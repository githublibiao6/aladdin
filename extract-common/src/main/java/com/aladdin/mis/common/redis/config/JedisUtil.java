package com.aladdin.mis.common.redis.config;

import com.alibaba.fastjson.JSONArray;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * jedis工具类
 */
public class JedisUtil {

    public static Redis use(int index) {
        return  new Redis(JedisConfig.getJedis(index));
    }

    /**
     * 字符串缓存
     * @param key
     * @param value
     * @return
     */
    public static boolean setString(String key, String value) {
        if(!JedisConfig.getEnableRedis()){
            return true;
        }
        Jedis jedis = JedisConfig.getJedis(0);
        String res = jedis.set(key,value);
        jedis.close();
        return "OK".equals(res);
    }

    /**
     * 字符串缓存, 设置超时时间 单位s
     * @param key
     * @param value
     * @return
     */
    public static boolean setString(String key, int seconds, String value) {
        if(!JedisConfig.getEnableRedis()){
            return true;
        }
        Jedis jedis = JedisConfig.getJedis(0);
        String res = jedis.setex(key, seconds, value);
        jedis.close();
        return "OK".equals(res);
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public static String getString(String key) {
        if(!JedisConfig.getEnableRedis()){
            return "";
        }
        Jedis jedis = JedisConfig.getJedis(0);
        String data = jedis.get(key);
        jedis.close();
        return data;
    }


    /**
     * 存放list
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    public static <T> boolean setList(String key, List<T> list) {
        if(!JedisConfig.getEnableRedis()){
            return true;
        }
        JSONArray arr = new JSONArray();
        arr.addAll(list);
        String res = JedisConfig.getJedis(0).set(key,arr.toJSONString());
        Jedis jedis = JedisConfig.getJedis(0);
        jedis.select(0);
        jedis.close();
        return "OK".equals(res);
    }

    /**
     *  获取list
     * @param key
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(String key) {
        if(!JedisConfig.getEnableRedis()){
            return null;
        }
        List<T> list = new ArrayList<>();
        Jedis jedis = JedisConfig.getJedis(0);
        String str = jedis.get(key);
        JSONArray arr = (JSONArray) JSONArray.parse(str);
        arr.forEach(t->{
            list.add((T)t);
        });
        jedis.close();
        return list;
    }

    /**
    * @Description: 设置对象
    * @Param: [key, o]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/4/15 22:28
    */
    public static <T> boolean setObject(String key, T o) {
        if(!JedisConfig.getEnableRedis()){
            return true;
        }
        Jedis jedis = JedisConfig.getJedis(0);
        String res = jedis.set(key,o.toString());
        jedis.close();
        return "OK".equals(res);
    }

    /**
     *  获取对象
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getObject(String key) {
        if(!JedisConfig.getEnableRedis()){
            return null;
        }
        Jedis jedis = JedisConfig.getJedis(0);
        String o = jedis.get(key);
        jedis.close();
        return (T)o;
    }

}
