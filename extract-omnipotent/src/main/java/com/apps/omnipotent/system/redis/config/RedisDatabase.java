package com.apps.omnipotent.system.redis.config;
/*
 *  Created by cles on 2020/8/3 0:04
 */

/**
 * @author cles
 * @description:
 * @Date 2020/8/3 0:04
 * @version: 1.0.0
 */

public enum RedisDatabase {

    /**
     * 缓存返回数据
     */
    API(0)
    /**
     * 缓存数据
     */
    ,DATA(1);
    private int index;


    public int getiIdex() {
        return index;
    }

    private RedisDatabase(int index) {
        this.index = index;
    }
}

