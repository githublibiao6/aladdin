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
public class LoginUser {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

}
