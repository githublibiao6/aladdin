package com.aladdin.mis.common.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * 应用配置
 * @author libia
 */
public class ApplicationConfig {


    @Value("${global.appKey:0}")
    public static String appKey;

    @Value("${global.appSecret:0}")
    public static String appSecret;
}
