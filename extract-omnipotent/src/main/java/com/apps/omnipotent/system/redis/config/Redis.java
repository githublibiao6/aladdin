package com.apps.omnipotent.system.redis.config;
/*
 *  Created by cles on 2020/8/3 0:25
 */

import com.alibaba.fastjson.JSONArray;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cles
 * @description:
 * @Date 2020/8/3 0:25
 * @version: 1.0.0
 */
public class Redis {

    private Jedis jedis;

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public Redis(){}
    public Redis(Jedis jedis){
        this.jedis = jedis;
    }

    /**
     * 字符串缓存
     * @param key
     * @param value
     * @return
     */
    public boolean setString(String key, String value) {
        String res = jedis.set(key,value);
        return "OK".equals(res);
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public String getString(String key) {
        return jedis.get(key);
    }


    /**
     * 存放list
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    public <T> boolean setList(String key, List<T> list) {
        JSONArray arr = new JSONArray();
        arr.addAll(list);
        String res = jedis.set(key,arr.toJSONString());
        return "OK".equals(res);
    }

    /**
     *  获取list
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key) {
        List<T> list = new ArrayList<>();
        String str = jedis.get(key);
        JSONArray arr = (JSONArray) JSONArray.parse(str);
        arr.forEach(t->{
            list.add((T)t);
        });
        return list;
    }

    /**
     * @Description: 设置对象
     * @Param: [key, o]
     * @return: boolean
     * @Author: cles
     * @Date: 2020/4/15 22:28
     */
    public <T> boolean setObject(String key, T o) {
        String res = jedis.set(key,o.toString());
        return "OK".equals(res);
    }

    /**
     *  获取对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObject(String key) {
        String o = jedis.get(key);
        return (T)o;
    }
}
