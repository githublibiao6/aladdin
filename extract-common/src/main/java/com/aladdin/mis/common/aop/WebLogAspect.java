package com.aladdin.mis.common.aop;
/*
 *  Created by cles on 2021/8/12 22:34
 */

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.mongodb.service.VisitLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.system.entity.VisitLog;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cles
 * @description:
 * @Date 2021/8/12 22:34
 * @version: 1.0.0
 */
@Aspect
@Component
public class WebLogAspect {

    @Autowired
    VisitLogService visitLogService;

//    @Autowired
//    SysWebLogService sysWebLogService;

    static User user = new User();
    static {
        user.setId(0);
        user.setName("游客");
    }

    @Pointcut("@annotation(com.aladdin.mis.common.annotation.WebLog)")
    public void annotationPointcut() {

    }


    @Around(value = "@annotation(webLog)")
    public Object doAround(ProceedingJoinPoint point, WebLog webLog){
        VisitLog log = new VisitLog();
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        log.setCode(2000);
        //获取方法名（是方法名不是RequestMapping）
        String methodName = point.getSignature().getName();
        log.setMethodName(methodName);
        //获取所有参数和参数值
        Map<String,Object> map = this.getNameAndValue(point);
        //将所有参数转成JSON保存（最好加密一下，我这里没加密）
        JSONObject json = new JSONObject(map);
        log.setRequestParam(json.toJSONString());
        GlobalController baseController = (GlobalController)point.getThis();
        HttpServletRequest request = baseController.getRequest();
        String method = request.getMethod();
        log.setRequestType(method);
        log.setRequestUrl(request.getRequestURL().toString());

        String ip = baseController.getIp();
        log.setRequestIp(ip);
        Subject subject = SecurityUtils.getSubject();

        OmUser m = (OmUser)subject.getPrincipal();
        if(m != null){
            log.setRequestUserName(m.getUserName());
        }
        Object resultData = null;

        // 通过webLog控制的都需要加校验控制
        boolean permitted = subject.isPermitted("menu/treeList");
//        if(!permitted){
//            Result result = new Result();
//            result.setRequestId(result.getRequestId());
//            result.setCode(401);
//            result.setSuccess(false);
//            result.setMessage("无权限，请联系管理员吧！（unauthorized）");
//            result.setData(log.getRequestUrl());
//
//            log.setRequestId(result.getRequestId());
//            log.setCode(401);
//            log.setMessage("无权限，请联系管理员吧！（unauthorized）");
//            log.setResponseData(JSONObject.toJSONString(result));
//            LocalDateTime end = LocalDateTime.now();
//            log.setEndTime(end);
//            Duration duration = Duration.between(start,  end);
//            long cost = duration.toMillis();
//            log.setCost(cost);
//            visitLogService.saveVisitLog(log);
//            return result;
//        }
        try {
            resultData = point.proceed();
        } catch (Throwable e) {
            log.setCode(19999);
            e.printStackTrace();
        }
        LocalDateTime end = LocalDateTime.now();
        log.setEndTime(end);
        Duration duration = Duration.between(start,  end);
        long cost = duration.toMillis();
        log.setCost(cost);

        if(resultData != null){
            System.err.println(resultData.toString());
            Result result = (Result) resultData;
            log.setRequestId(result.getRequestId());
            log.setCode(result.getCode());
            log.setMessage(result.getMessage());
            log.setResponseData(resultData.toString());
        }
        visitLogService.saveVisitLog(log);
        // todo log保存
        return resultData;
    }

    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return map
     */
    private Map<String, Object> getNameAndValue(JoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        return param;
    }

}
