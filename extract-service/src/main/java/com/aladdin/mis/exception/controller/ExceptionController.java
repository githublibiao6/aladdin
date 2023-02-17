package com.aladdin.mis.exception.controller;
/*
 *  Created by cles on 2022/2/21 23:37
 */

import com.aladdin.mis.mongdb.service.VisitExceptionLogService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.entity.VisitExceptionLog;
import com.aladdin.mis.common.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ExceptionController{

    @Autowired
    private VisitExceptionLogService visitExceptionLogService;

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Result error(Exception e){
        VisitExceptionLog exceptionLog = new VisitExceptionLog();
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(50000);
        result.setData("系统发生未知错误");
        result.setMessage(e.getMessage());
        exceptionLog.setCode(404);
        exceptionLog.setException(e.getMessage());
        exceptionLog.setException(ExceptionUtil.getStackTrace(e));
        exceptionLog.setTitle("未知错误" + e.getMessage());
        visitExceptionLogService.saveVisitExceptionLog(exceptionLog);
        log.error("系统发生未知错误");
        e.printStackTrace();
        return result;

    }
}
