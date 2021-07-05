package com.apps.omnipotent.system.redis.entity;

import lombok.Data;

/**
* @Description:  客户端信息
* @Author: cles
* @Date: 2020/4/17 23:55
*/
@Data
public class ClientInfo {

    private String id;

    private String addr;

    private String age;

    private String db;
}
