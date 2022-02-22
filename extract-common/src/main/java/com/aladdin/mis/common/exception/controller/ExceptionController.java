package com.aladdin.mis.common.exception.controller;
/*
 *  Created by cles on 2022/2/21 23:37
 */

import com.aladdin.mis.common.system.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author cles
 * @description:
 * @Date 2022/2/21 23:37
 * @version: 1.0.0
 */
@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Result error(Exception e){
        Result result = new Result();
        result.setCode(500);
        result.setSuccess(false);
        result.setData(UUID.randomUUID().toString());
        result.setMessage("系统发生未知错误");
        return result;

    }
}
