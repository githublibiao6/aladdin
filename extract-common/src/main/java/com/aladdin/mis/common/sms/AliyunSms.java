package com.aladdin.mis.common.sms;
/*
 *  Created by cles on 2022/3/15 22:50
 */

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

import java.util.List;

/**
 * @author cles
 * @description: 阿里云短信发送
 * @Date 2022/3/15 22:50
 * @version: 1.0.0
 */
public class AliyunSms {

    private final static String accessKeyId="";
    private final static String accessKeySecret="";


    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dysmsapi20170525.Client client = AliyunSms.createClient(accessKeyId, accessKeySecret);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("1327541355")
                .setTemplateParam("{\"code\":\"9521\"}");
        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody();
        // OK
        System.err.println(body.getCode());
        // OK
        System.err.println(body.getMessage());
        // C9426875-E0BB-57E1-87A9-4704643A21DB
        System.err.println(body.getRequestId());
        // 889706047357011643^0
        System.err.println(body.getBizId());
        System.err.println(body.toString());

    }
}
