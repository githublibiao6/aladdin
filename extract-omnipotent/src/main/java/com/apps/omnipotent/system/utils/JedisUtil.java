package com.apps.omnipotent.system.utils;

import com.alibaba.fastjson.JSONArray;
import com.apps.omnipotent.system.redis.config.JedisConfig;
import com.apps.omnipotent.system.redis.config.Redis;
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

//    /**
//     * 字符串缓存
//     * @param key
//     * @param value
//     * @return
//     */
//    public static boolean setString(String key, String value) {
//        String res = JedisConfig.getJedis(0).set(key,value);
//        return "OK".equals(res);
//    }
//
//    /**
//     * 获取字符串
//     * @param key
//     * @return
//     */
//    public static String getString(String key) {
//        return JedisConfig.jedis.get(key);
//    }
//
//
//    /**
//     * 存放list
//     * @param key
//     * @param list
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean setList(String key, List<T> list) {
//        JSONArray arr = new JSONArray();
//        arr.addAll(list);
//        String res = JedisConfig.getJedis(0).set(key,arr.toJSONString());
//        Jedis jeids = JedisConfig.getJedis(0);
//        jeids.select(0);
//        return "OK".equals(res);
//    }
//
//    /**
//     *  获取list
//     * @param key
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> getList(String key) {
//        List<T> list = new ArrayList<>();
//        String str = JedisConfig.jedis.get(key);
//        JSONArray arr = (JSONArray) JSONArray.parse(str);
//        arr.forEach(t->{
//            list.add((T)t);
//        });
//        return list;
//    }
//
//    /**
//    * @Description: 设置对象
//    * @Param: [key, o]
//    * @return: boolean
//    * @Author: cles
//    * @Date: 2020/4/15 22:28
//    */
//    public static <T> boolean setObject(String key, T o) {
//        String res = JedisConfig.getJedis(0).set(key,o.toString());
//        return "OK".equals(res);
//    }
//
//    /**
//     *  获取对象
//     * @param key
//     * @param <T>
//     * @return
//     */
//    public static <T> T getObject(String key) {
//        String o = JedisConfig.jedis.get(key);
//        return (T)o;
//    }

}
