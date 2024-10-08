package com.aladdin.mis.bill.service;
/*
 *  Created by cles on 2020/7/14 23:24
 */

import javax.servlet.http.HttpServletRequest;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:24
 * @version: 1.0.0
 */

public interface AlipayService {

    /**
     * 功能描述：
     *  < 测试service >
     * @Description: index
     * @Author: cles
     * @Date: 2020/7/14 23:25
     * @return: void
     * @version: 1.0.0
     */
    String index();

    /**
     * 支付回调地址
     * @param request
     * @return
     */
    String notifyUrl(HttpServletRequest request);
}
