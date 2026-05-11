package com.aladdin.common.core.cache;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 字典缓存服务
 *
 * @author cles
 * @date 2026/05/06
 */
@Component
public class DictCacheService {

    private static final String DICT_TYPE_PREFIX = "dict:type:";
    private static final String DICT_DATA_PREFIX = "dict:data:";

    private final StringRedisTemplate redisTemplate;

    public DictCacheService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 缓存字典类型
     */
    public void cacheDictType(String dictType, Map<String, Object> typeInfo) {
        redisTemplate.opsForValue().set(DICT_TYPE_PREFIX + dictType, JSON.toJSONString(typeInfo));
    }

    /**
     * 获取字典类型
     */
    public Map<String, Object> getDictType(String dictType) {
        String json = redisTemplate.opsForValue().get(DICT_TYPE_PREFIX + dictType);
        if (json == null) {
            return null;
        }
        return JSON.parseObject(json, new TypeReference<Map<String, Object>>() {});
    }

    /**
     * 缓存字典数据列表
     */
    public void cacheDictData(String dictType, List<Map<String, Object>> dataList) {
        redisTemplate.opsForValue().set(DICT_DATA_PREFIX + dictType, JSON.toJSONString(dataList));
    }

    /**
     * 获取字典数据列表
     */
    public List<Map<String, Object>> getDictData(String dictType) {
        String json = redisTemplate.opsForValue().get(DICT_DATA_PREFIX + dictType);
        if (json == null) {
            return Collections.emptyList();
        }
        return JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {});
    }

    /**
     * 根据字典值获取标签
     */
    public String getDictLabel(String dictType, String dictValue) {
        List<Map<String, Object>> dataList = getDictData(dictType);
        for (Map<String, Object> item : dataList) {
            Object value = item.get("dictValue");
            if (value != null && value.toString().equals(dictValue)) {
                Object label = item.get("dictLabel");
                return label != null ? label.toString() : "";
            }
        }
        return "";
    }

    /**
     * 删除字典缓存
     */
    public void removeDict(String dictType) {
        redisTemplate.delete(DICT_TYPE_PREFIX + dictType);
        redisTemplate.delete(DICT_DATA_PREFIX + dictType);
    }

    /**
     * 清空所有字典缓存
     */
    public void clearAll() {
        Set<String> keys = redisTemplate.keys("dict:*");
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }
}
