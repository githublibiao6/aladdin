package com.aladdin.mis.common.sso;
/*
 *  Created by cles on 2021/12/28 0:10
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author cles
 * @description: sso验证
 * @Date 2021/12/28 0:10
 * @version: 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "global.sso")
public class SsoAuth {

    /**
     * 是否启用sso
     */
    private boolean enable;

    /**
     * sso路径
     */
    private String  url;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getUrl() {
        return url;
    }

    /**
     * 检验是否登录
     * @param token
     */
    public static void verifyLogin(String token){

        System.err.println("模拟sso登录");
    }

    public static void verifyAuth(String token){

        System.err.println("模拟sso权限");
    }
}
