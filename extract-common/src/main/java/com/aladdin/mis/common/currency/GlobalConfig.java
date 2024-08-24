package com.aladdin.mis.common.currency;
/*
 *  Created by cles on 2022/4/18 20:27
 */

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 全局配置信息
 * @author cles
 * @description: 全局配置中心
 * @Date 2022/4/18 20:27
 * @version: 1.0.0
 */
@Component
@Data
public class GlobalConfig {

    /**
     * 是否开启全局校验
     */
    @Value("${global.verify.enable:false}")
    public static boolean verifyEnable;

    /**
     * 是否开启全局校验
     */
    @Value("${global.verify.enable:false}")
    public boolean verifyEnable1;


    /**
     * 是否开启验证码的校验
     */
    @Value("${global.verify.code:false}")
    public static boolean verifyCode;

    /**
     * 是否开启验证码的校验
     */
    @Value("${global.verify.sms:false}")
    public static boolean verifySms;

    // todo 系统参数的开发
}
