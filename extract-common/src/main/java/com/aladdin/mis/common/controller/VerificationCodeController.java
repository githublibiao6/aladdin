package com.aladdin.mis.common.controller;
/*
 *  Created by cles on 2022/4/18 20:12
 */

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.aladdin.mis.common.currency.Parameter;
import com.aladdin.mis.common.redis.config.JedisUtil;
import com.aladdin.mis.common.service.VerificationCodeService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cles
 * @description: 验证码
 * @Date 2022/4/18 20:12
 * @version: 1.0.0
 */
@RequestMapping("verifyCode")
@Controller
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 获取验证码
     */
    @RequestMapping("/getCode")
    @ResponseBody
    public Result getCode(@RequestBody UserVo vo,  HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 47);
        String code = lineCaptcha.getCode();
        String sessionId = vo.getSessionId();
        // 将验证码放入redis缓存， 等待验证
        JedisUtil.setString(Parameter.VerifyCodePrefix+":"+ sessionId , 60 * 2 , code);
//        result.setData(lineCaptcha);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            lineCaptcha.write(response.getOutputStream());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        boolean s = lineCaptcha.verify("1234");

        //重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
        //新的验证码
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
    }
}
