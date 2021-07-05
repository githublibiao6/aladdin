package com.apps.omnipotent.system.redis.config;


import com.apps.omnipotent.system.redis.entity.Connect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
//@Configuration
//@EnableAutoConfiguration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    /**
     * 可用连接实例的最大数目，默认值为8；
     */
    private static final int MAX_TOTAL = 50;

    /**
     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
     */
    private static final int MAX_IDLE = 10;

    /**
     * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
     */
    private static final int MAX_WAIT = 3000;

    /**
     * 超时时间
     */
    private static final int TIME_OUT = 3000;

    /**
     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
     */
    private static final boolean TEST_ON_BORROW = true;

    private static final boolean TEST_ON_RETURN = true;

    /**
     * redis连接池
     */
    public static JedisPool jedisPool;

    public static Jedis jedis;

    /**
     * 资源锁
     */
    private static ReentrantLock lock = new ReentrantLock();

    /**
     * JedisPoolConfig配置
     * @return
     */
    @Bean
    public void getJjedisPool() {
        log.info("初始化JedisPoolConfig");
        Connect  connect = new Connect();
        connect.setRhost(host);
        connect.setRport(port);
        connect.setRpass(password);
        connect.setType("0");
        try {
            openJedis(connect);
        } catch (Exception e) {
            log.info("初始化jedis错误");
            e.printStackTrace();
        }
    }

    /**
     * 从JedisPool中获取Jedis
     */
    private static void openJedis(Connect connect){
        log.info("正在建立新连接...");
        //销毁旧的连接池
        freeJedisPool();
        //防止吃初始化时多线程竞争问题
        lock.lock();
        try{
            initJedisPool(connect);
        }catch (Exception e){
            log.info("redis连接错误");
            e.printStackTrace();
        }
        lock.unlock();
        jedis = jedisPool.getResource();
    }

    /**
     * 初始化JedisPool
     */
    private static void initJedisPool(Connect connect) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setMaxTotal(MAX_TOTAL);
        config.setTestOnBorrow(TEST_ON_BORROW);
        String host = connect.getRhost();
        config.setTestOnReturn(TEST_ON_RETURN);
        int port = Integer.valueOf(connect.getRport());
        if (connect.getType().equals("1")) {
            port = 55555;
            if (host.equals(connect.getShost())) {
                host = "127.0.0.1";
            }
        }
        if (StringUtils.isEmpty(connect.getRpass())) {
            jedisPool = new JedisPool(config, host, port, TIME_OUT);
        } else {
            jedisPool = new JedisPool(config, host, port, TIME_OUT, connect.getRpass());
        }
    }

    /**
     * 释放当前Redis连接池
     */
    public static void freeJedisPool() {
        if (null != jedisPool && !jedisPool.isClosed()) {
            jedisPool.destroy();
        }
    }

    public static Jedis getJedis(int index) {
        if(jedis == null){
            log.info("redis初始化错误");
            return new Jedis();
        }
        jedis.select(index);
        return jedis;
    }
}
