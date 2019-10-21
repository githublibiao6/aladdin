package com.company.system.redis.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.company.manage.admin.bean.Admin;
import com.company.system.redis.dao.RedisBaiseTakes;

/**
 * 
 * @author lb
 * @date 2018年5月28日 下午8:47:29
 */
@Component
public class RedisBaiseTakesImpl implements RedisBaiseTakes<String,String,Admin>{
//    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(RedisBaiseTakesImpl.class));
    public void add(String key, String value) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
           redisTemplate.opsForValue().set(key,value);
        }
    }

    
    public void addObj(String objectKey, String key, Admin object) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
    }

    
    public void delete(String key) {

    }

    
    public void delete(List<String> listKeys) {

    }

    
    public void deletObj(String objecyKey, String key) {

    }

    
    public void update(String key, String value) {

    }

    
    public void updateObj(String objectKey, String key, Admin object) {
        
    }

    
    public String get(String key) {
        return null;
    }

    
    public Admin getObj(String objectKey, String key) {
        return null;
    }

}