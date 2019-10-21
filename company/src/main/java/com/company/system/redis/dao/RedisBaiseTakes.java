package com.company.system.redis.dao;

import java.util.List;

/**
 * redis 
 * @author lb
 * @date 2018年5月28日 下午8:51:08
 */

public interface RedisBaiseTakes<H,K,V> {
    
    //增
    public void add(K key,String value);
    public void addObj(H objectKey,K key,V object);
    
    //删
    public void delete(K key);
    public void delete(List<K> listKeys);
    public void deletObj(H objecyKey,K key);
    
    //改
    public void update(K key,String value);
    public void updateObj(H objectKey,K key,V object);
    
    //查
    public String get(K key);
    public V getObj(H objectKey,K key);
}