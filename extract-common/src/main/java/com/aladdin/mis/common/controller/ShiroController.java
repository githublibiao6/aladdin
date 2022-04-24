package com.aladdin.mis.common.controller;
/*
 *  Created by cles on 2022/4/18 20:12
 */

import com.aladdin.mis.common.system.entity.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * session 很多浏览器多次请求的session不一致
 * 所以在这返回一个固定的session
 */
@RequestMapping("shiro")
@Controller
public class ShiroController {

    /**
     * 获取验证码
     */
    @RequestMapping("/getSessionId")
    @ResponseBody
    public Result getCode(HttpServletRequest request) {
        String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
        return Result.success(sessionId);
    }
}
