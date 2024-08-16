package com.aladdin.mis.bill.service.impl;
/*
 *  Created by cles on 2020/7/14 23:24
 */

import com.aladdin.mis.bill.config.AliPayConfig;
import com.aladdin.mis.bill.service.AlipayService;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:24
 * @version: 1.0.0
 */
@Slf4j
@Service
public class AlipayServiceImpl2 implements AlipayService {

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
//        https://blog.csdn.net/HUDCHSDI/article/details/91442480
        // 构建支付数据信息
        Map<String, String> data = new HashMap<>();
        //买家支付宝用户ID。 支付宝预授权和新当面资金授权场景下必填，其它场景不需要传入。
//        data.put("buyer_id", "2088102181423530");
        //商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复      //此处模拟订单号为时间
        data.put("out_trade_no", "20150320010101001");
        // 订单标题。 注意：不可使用特殊字符，如 /，=，& 等。
        data.put("subject", "nelson-test-title");
        // 支付授权码。 当面付场景传买家的付款码（25~30开头的长度为16~24位的数字，实际字符串长度以开发者获取的付款码长度为准）或者刷脸标识串（fp开头的35位字符串）； 周期扣款或代扣场景无需传入，协议号通过agreement_params参数传递； 支付宝预授权和新当面资金授权场景无需传入，授权订单号通过 auth_no字段传入。 注：交易的买家与卖家不能相同。
//        data.put("auth_code", "fOIcQmEHtQivyZdKMWYiuQ==");
        // 这是什么参数？
        // 支付场景。枚举值： bar_code：当面付条码支付场景；
        // security_code：当面付刷脸支付场景，
        // 对应的auth_code为fp开头的刷脸标识串；
        // 周期扣款或代扣场景无需传入，协议号通过agreement_params参数传递； 支付宝预授权和新当面资金授权场景无需传入，授权订单号通过 auth_no字段传入。 默认值为bar_code。
//        data.put("scene", "bar_code");
        //该笔订单允许的最晚付款时间
        data.put("time_expire", "2024-08-16 05:05:01");
        //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        data.put("total_amount","10.01");
        //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        // 产品码。 商家和支付宝签约的产品码。 枚举值（点击查看签约情况）：
        // FACE_TO_FACE_PAYMENT：当面付产品；
        // CYCLE_PAY_AUTH：周期扣款产品；
        // GENERAL_WITHHOLDING：代扣产品；
        // PRE_AUTH_ONLINE：支付宝预授权产品；
        // PRE_AUTH：新当面资金授权产品；
        // 默认值为FACE_TO_FACE_PAYMENT。 注意：非当面付产品使用本接口时，本参数必填。请传入对应产品码。
        data.put("product_code", "FAST_INSTANT_TRADE_PAY");
//        data.put("product_code", "QUICK_MSECURITY_PAY");

        // 封装请求支付信息
//        面对面支付？
//        AlipayTradePagePayModel model=new AlipayTradeWapPayModel();
        AlipayTradePagePayModel  model=new AlipayTradePagePayModel ();
        model.setOutTradeNo(System.currentTimeMillis()+"");
        model.setSubject("subject");
        model.setTotalAmount("20.10");
        model.setBody("bb");
        model.setTimeoutExpress("30m");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        // 面对面支付？
//        model.setProductCode("FACE_TO_FACE_PAYMENT");
        String sign= null;
        try {
            sign = AlipaySignature.rsaSign(JSON.toJSONString(data), AliPayConfig.merchantPrivateKey, AliPayConfig.charset,AliPayConfig.signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("sign:"+ sign);

//        data.put("goods_id", "apple-1");
//        data.put("goods_name", "no.1");
//        data.put("quantity", "5");
//        data.put("price", "20");

        //构建客户端
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.gatewayUrl,
                AliPayConfig.appId,
                AliPayConfig.merchantPrivateKey,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipayPublicKey,
                AliPayConfig.signType);
        String key = AliPayConfig.merchantPrivateKey;
        // 面对面支付？
//        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest ();
        // 网页支付

        // https://open.alipay.com/api?appId=2021001177611448 开通需要营业执照，网址等
        AlipayTradePagePayRequest  request = new AlipayTradePagePayRequest ();
        request.setNeedEncrypt(false);
// APP支付
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
// 移动h5
//        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();

        CertAlipayRequest certAlipayRequest   =   new   CertAlipayRequest ();

//        request.setNotifyUrl(AliPayConfig.notifyUrl);
//        request.setReturnUrl(AliPayConfig.returnUrl);
//        AlipaySignature.rsaCertCheckV2()
        request.setBizModel(model);
        request.setBizContent(JSON.toJSONString(data));

        System.err.println(JSON.toJSONString(data));
        log.info(JSON.toJSONString(data));
        String res = null;
        // 面对面支付？
//        AlipayTradePrecreateResponse response = null;
        AlipayTradePagePayResponse response = null;
        try {
//            AlipayTradePagePayResponse response = alipayClient.certificateExecute(request);
            response = alipayClient.pageExecute(request);
            System.err.println(response);
            res = response.getBody();
            System.err.println(response.getOutTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.err.println("res" + res);
        return res;
    }
}
