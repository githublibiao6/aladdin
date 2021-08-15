package com.aladdin.mis.common.aop;
/*
 *  Created by cles on 2021/8/12 22:34
 */

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.manager.bean.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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
//    @Autowired
//    RedisAPPTool redisAPPTool;
//    @Autowired
//    FUserLogService fUserLogService;

    static User user = new User();
    static {
        user.setId(0);
        user.setName("游客");
    }

    @Pointcut("@annotation(com.aladdin.mis.common.annotation.WebLog)")
    public void annotationPointcut() {

    }


    @Around(value = "@annotation(webLog)")
    public void  doAround(ProceedingJoinPoint point, WebLog webLog){
        //获取方法名（是方法名不是RequestMapping）
        String methodName = point.getSignature().getName();
        //获取所有参数和参数值
        Map<String,Object> map = this.getNameAndValue(point);
        //将所有参数转成JSON保存（最好加密一下，我这里没加密）
        JSONObject json = new JSONObject(map);
        GlobalController baseController = (GlobalController)point.getThis();
        HttpServletRequest request = baseController.getRequest();

        System.out.println(baseController.getProjectUrl());
        baseController.getIp();
        System.out.println("userLog:" + methodName + "--");
        System.err.println(request.getHeader("Authorization"));
        Subject subject = SecurityUtils.getSubject();
        Object m = subject.getPrincipal();
        System.err.println(json);
        System.err.println(webLog.value());
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //UserLog log = method.getAnnotation(UserLog.class);
    }

    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return
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
