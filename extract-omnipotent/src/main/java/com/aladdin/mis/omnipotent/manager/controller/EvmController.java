package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.common.core.utils.EVMUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/evm")
public class EvmController {

    @RequestMapping("/index")
    @ResponseBody
    public void productcode() {
        EVMUtils.zxingCodeCreate("http://www.baidu.com", "D:/voice/picture/2018/",500,"D:/voice/picture/2018/5.jpg");
    }

    @RequestMapping("/index2")
    @ResponseBody
    public void analysiscode() {
        Object result = EVMUtils.zxingCodeAnalyze("D:/voice/picture/2018/759.jpg");
        System.err.println("二维码解析内容："+result);
    }
}
