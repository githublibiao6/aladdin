package com.aladdin.mis.manager.dto;

import com.aladdin.mis.manager.bean.User;
import lombok.Data;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class UserDto extends User {


    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 验证码
     */
    private String sessionId;
}
