package com.aladdin.mis.base.model.param;

/**
 * 用户model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2025年9月23日 下午10:50:54
 */
public record LoginUser(
        /*
         * 用户名
         */
        String userName,

        /*
         * 密码
         */
        String password,

        /*
         * 登录来源
         */
        String datasource) {

}
