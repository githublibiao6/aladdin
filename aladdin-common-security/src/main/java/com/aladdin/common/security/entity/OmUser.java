package com.aladdin.common.security.entity;

import lombok.Data;

/**
 * 用户信息
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class OmUser {

    private Integer userId;

    private String loginName;

    private String userName;

    private String userType;

    private Integer deptId;

    private String deptName;
}
