package com.aladdin.mis.annotation.po;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员实体类
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Data
public class AdminTest implements Serializable {

    /**
    * 编码
     */
    private String id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登陆密码
     */
    private String loginPassword;

    /**
     * 部门
     */
    private String deptId;

    /**
     * 说明
     */
    private String notes;
}
