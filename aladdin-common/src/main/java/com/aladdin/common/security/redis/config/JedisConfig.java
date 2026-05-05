package com.aladdin.common.security.redis.config;

import com.aladdin.common.core.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Jedis连接池配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
@Configuration
@ConditionalOnProperty(name = "spring.redis.host")
public class JedisConfig {

    @Value("${spring.redis.host:}")
    private String host;
    @Value("${spring.redis.port:6379}")
    private String port;
    @Value("${spring.redis.password:}")
    private String password;
    @Value("${spring.redis.database:0}")
    private int database;
    @Value("${spring.redis.jedis.pool.max-idle:10}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.max-wait:3000}")
    private long maxWaitMillis;
    @Value("${spring.redis.jedis.pool.max-active:50}")
    private int maxActive;
    @Value("${aladdin.security.redis.enabled:true}")
    private boolean enableRedis;

    private static final int MAX_TOTAL = 50;
    private static final int MAX_IDLE = 10;
    private static final int MAX_WAIT = 3000;
    private static final int TIME_OUT = 5000;
    private static final boolean TEST_ON_BORROW = true;
    private static final boolean TEST_ON_RETURN = true;

    public static JedisPool jedisPool;
    public static Jedis jedis;

    private static ReentrantLock lock = new ReentrantLock();

    private static boolean enable;

    @Bean
    public int initJedis() {
        log.info("初始化JedisPoolConfig");
        try {
            if (enableRedis) {
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxIdle(MAX_IDLE);
                config.setMaxWaitMillis(MAX_WAIT);
                config.setMaxTotal(MAX_TOTAL);
                config.setTestOnBorrow(TEST_ON_BORROW);
                config.setTestOnReturn(TEST_ON_RETURN);
                int portNum = Integer.parseInt(port);
                if (StringUtils.isEmpty(password)) {
                    jedisPool = new JedisPool(config, host, portNum, TIME_OUT);
                } else {
                    jedisPool = new JedisPool(config, host, portNum, TIME_OUT, password);
                }
                try {
                    jedis = jedisPool.getResource();
                } catch (Exception e) {
                    log.error("redis 启动报错\n{}", ExceptionUtil.getStackTrace(e));
                }
                enable = true;
            } else {
                log.info("redis未启动");
            }
        } catch (Exception e) {
            log.info("初始化jedis错误");
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public static Jedis getJedis(int index) {
        if (jedis == null) {
            log.info("redis初始化错误");
            return new Jedis();
        }
        jedis.select(index);
        return jedis;
    }

    public static boolean getEnableRedis() {
        return enable;
    }
}
