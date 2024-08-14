package com.aladdin.mis.bill.service.impl;
/*
 *  Created by cles on 2020/7/14 23:24
 */

import com.aladdin.mis.bill.config.AliPayConfig;
import com.aladdin.mis.bill.service.AlipayService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:24
 * @version: 1.0.0
 */
@Slf4j
//@Service
public class AlipayServiceImpl implements AlipayService {

    /**
     * 功能描述：
     *  < 测试service >
     * @Description: index
     * @Author: cles
     * @Date: 2020/7/14 23:25
     * @return: void
     * @version: 1.0.0
     */
    @Override
    public String index(){
        // 封装请求支付信息
        AlipayTradePagePayModel  model=new AlipayTradePagePayModel ();
        model.setOutTradeNo(System.currentTimeMillis()+"");
        model.setSubject("subject");
        model.setBody("bb");
        model.setTotalAmount("20.00");
        model.setTimeoutExpress("30m");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");

        //构建客户端
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.gatewayUrl,
                AliPayConfig.appId,
                AliPayConfig.merchantPrivateKey,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipayPublicKey,
                AliPayConfig.signType);
        // 网页支付
        AlipayTradePagePayRequest  request = new AlipayTradePagePayRequest ();

        request.setNotifyUrl(AliPayConfig.notifyUrl);
        request.setReturnUrl(AliPayConfig.returnUrl);
        request.setBizModel(model);

        String res = null;
        // 面对面支付？
//        AlipayTradePrecreateResponse response = null;
        AlipayTradePagePayResponse response = null;
        try {
            response = alipayClient.pageExecute(request);
            res = response.getBody();
            System.err.println(res);
            System.err.println(response.getOutTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return res;
    }
}
