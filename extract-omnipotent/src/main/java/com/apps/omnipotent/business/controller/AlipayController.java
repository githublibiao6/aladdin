package com.apps.omnipotent.business.controller;

import com.alipay.api.AlipayApiException;
import com.apps.omnipotent.business.service.AlipayService;
import com.apps.omnipotent.business.service.impl.AlipayServiceImpl;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.service.ProjectService;
import com.apps.omnipotent.system.utils.EVMUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
