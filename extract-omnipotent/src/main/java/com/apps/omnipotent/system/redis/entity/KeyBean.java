package com.apps.omnipotent.system.redis.entity;

import lombok.Data;

@Data
public class KeyBean {

    private long ttl;

    private long size;

    private String key;

    private String type;

    private String text;

    private String json;

    private String raws;

    private String hexs;

    private Object data;
}
