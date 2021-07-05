package com.apps.omnipotent.business.config;
/*
 *  Created by cles on 2020/7/14 23:23
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:23
 * @version: 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "alibaba.alipay")
public class AliPayConfig {
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
     */
    public static String appId ;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
     */
    public static String merchantPrivateKey;

    /**
     * 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
     */
    public static String alipayPublicKey ;
    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
     * neturl+"/alipay/notify_url"
     */
    public static String notifyUrl ;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
     * neturl+"/alipay/return_url";
     */
    public static String returnUrl ;

    /**
     * 签名方式
     */
    public static String signType ;

    /**
     * 字符编码格式
     */
    public static String charset;

    /**
     * 支付宝网关
     */
    public static String gatewayUrl ;

    public void setAppId(String appId) {
        AliPayConfig.appId = appId;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        AliPayConfig.merchantPrivateKey = merchantPrivateKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        AliPayConfig.alipayPublicKey = alipayPublicKey;
    }

    public void setNotifyUrl(String notifyUrl) {
        AliPayConfig.notifyUrl = notifyUrl;
    }

    public void setReturnUrl(String returnUrl) {
        AliPayConfig.returnUrl = returnUrl;
    }

    public void setSignType(String signType) {
        AliPayConfig.signType = signType;
    }

    public void setCharset(String charset) {
        AliPayConfig.charset = charset;
    }

    public void setGatewayUrl(String gatewayUrl) {
        AliPayConfig.gatewayUrl = gatewayUrl;
    }

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     */
    private  static void logResult(String sWord) {
        FileWriter writer = null;
        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
