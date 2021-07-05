package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.utils.EVMUtils;
import com.google.zxing.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述：
 *  < >
 * @Description: 二维码
 * @Author: cles
 * @Date: 2020/7/12 17:01
 * @return:
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/evm")
public class EvmController extends GlobalController {


    /** 测试异步执行
     * @Author cles
     * @Description 
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    @ResponseBody
    public void productcode() {
        EVMUtils.zxingCodeCreate("http://www.baidu.com", "D:/voice/picture/2018/",500,"D:/voice/picture/2018/5.jpg");
    }


    /**
     * 解析二维码
     */
    @RequestMapping("/index2")
    @ResponseBody
    public void analysiscode() {
        Result result = EVMUtils.zxingCodeAnalyze("D:/voice/picture/2018/759.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }
}
