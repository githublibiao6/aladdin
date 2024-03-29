package com.aladdin.mis.system.user.vo;


import lombok.Data;

/**
 * 用户model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2022年2月17日 下午10:50:54
 */
@Data
public class OmUser {

    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密 码
     */
    private String password;

    /**
     * 机构id
     */
    private Integer deptId;

    /**
     * 机构名称
     */
    private String deptName;


}
