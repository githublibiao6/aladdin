package com.aladdin.mis.common.exception.controller;
/*
 *  Created by cles on 2022/2/21 23:37
 */

import com.aladdin.mis.common.mongodb.service.VisitExceptionLogService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.utils.ExceptionUtil;
import com.aladdin.mis.system.entity.VisitExceptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cles
 * @description:
 * @Date 2022/2/21 23:37
 * @version: 1.0.0
 */
@ControllerAdvice
public class ExceptionController{

    @Autowired
    private VisitExceptionLogService visitExceptionLogService;

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Result error(Exception e){
        VisitExceptionLog log = new VisitExceptionLog();
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(50000);
        result.setData("系统发生未知错误");
        result.setMessage(e.getMessage());
        log.setCode(404);
        log.setException(e.getMessage());
        log.setException(ExceptionUtil.getStackTrace(e));
        log.setTitle("未知错误");
        visitExceptionLogService.saveVisitExceptionLog(log);
        return result;

    }
}
