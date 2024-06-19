package com.aladdin.mis.chat.config;
/*
 *  Created by cles on 2021/7/13 14:08
 */

import com.aladdin.mis.common.system.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cles
 * @description:
 * @Date 2021/7/13 14:08
 * @version: 1.0.0
 */
@RestController
@RequestMapping("base")
public class BaseController {

    @RequestMapping("healthy")
    @ResponseBody
    public Result healthy(){
        Result result = new Result();
        result.setMessage("请求成功");
        return result;
    }

    @RequestMapping("index")
    public void index(){
        System.err.println("index");
    }
}
