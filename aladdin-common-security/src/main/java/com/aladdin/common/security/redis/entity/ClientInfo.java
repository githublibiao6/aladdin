package com.aladdin.common.security.redis.entity;

import lombok.Data;

/**
 * Redis客户端信息
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class ClientInfo {

    private String id;

    private String addr;

    private String age;

    private String db;
}
