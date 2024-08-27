package com.aladdin.mis.identity.vo;

import com.aladdin.mis.identity.entity.User;
import lombok.Data;

/**

 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class UserVo extends User {

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号码
     */
    private String phone;



}
