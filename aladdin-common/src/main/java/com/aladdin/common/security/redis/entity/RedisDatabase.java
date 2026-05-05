package com.aladdin.common.security.redis.entity;

import lombok.Data;

/**
 * Redis数据库枚举
 *
 * @author cles
 * @date 2026/04/30
 */
public enum RedisDatabase {

    API(0),
    DATA(1);

    private int index;

    public int getIndex() {
        return index;
    }

    RedisDatabase(int index) {
        this.index = index;
    }
}
