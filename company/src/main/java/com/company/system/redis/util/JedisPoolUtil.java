package com.company.system.redis.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static JedisPool jedisPool = null;

    public static JedisPool getJedisPool(){
        synchronized(JedisPoolUtil.class){  //解决高并发问题
            JedisPoolConfig jpc = new JedisPoolConfig();    //获取jedispool连接池配置类

            jpc.setMaxIdle(32);         //最大空闲连接
            jpc.setMaxTotal(500);       //最大活动连接
            jpc.setMaxWaitMillis(100000); //最长等待时间

            jedisPool = new JedisPool(jpc, "192.168.111.129", 6379);
        }
        return jedisPool;

    }
}
