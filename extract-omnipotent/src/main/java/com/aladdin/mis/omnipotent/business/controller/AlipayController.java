package com.aladdin.mis.omnipotent.business.controller;

import com.aladdin.mis.dao.manager.AdminDao;
import com.aladdin.mis.omnipotent.business.service.impl.AlipayServiceImpl;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 支付 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("pay")
@Controller
public class AlipayController {

    @Autowired
    AlipayServiceImpl service;
    /** 测试异步执行
     * @Author cles
     * @Description
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    @ResponseBody
    public String alipay() throws AlipayApiException {
        return service.index();
    }

    /**
     *  聊天测试
     * @return
     */
    @RequestMapping("/success")
    public String chat() {
        return "alipay/success";
    }

    /**
     *  聊天测试
     * @return
     */
    @RequestMapping("/notify")
    public String index2() {
        return "alipay/notify";
    }

}
