package com.aladdin.mis.common.exception.controller;
/*
 *  Created by cles on 2022/2/21 23:37
 */

import com.aladdin.mis.common.mongodb.service.VisitExceptionLogService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.entity.VisitExceptionLog;
import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author cles
 * @description:
 * @Date 2022/2/21 23:37
 * @version: 1.0.0
 */
@Controller
public class NotFoundController implements ErrorController {

    @Autowired
    private VisitExceptionLogService visitExceptionLogService;

    @RequestMapping(value = {"/error"})
    @ResponseBody
    public Result error(HttpRequest request){
        VisitExceptionLog log = new VisitExceptionLog();
        Result result = new Result();
        result.setCode(404);
        result.setSuccess(false);
        result.setData(UUID.randomUUID().toString());
        result.setMessage("NOT FOUND");
        log.setCode(404);
        log.setTitle("未找到指定路径");
        visitExceptionLogService.saveVisitExceptionLog(log);
        return result;

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
