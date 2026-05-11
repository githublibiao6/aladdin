package com.aladdin.common.db.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

/**
 * 数据源切换拦截器
 *
 * @author cles
 * @date 2026/05/06
 */
public class DynamicDataSourceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        DS ds = getDSAnnotation(invocation.getMethod(), invocation.getThis().getClass());
        String key = ds != null ? ds.value() : "master";
        try {
            DynamicDataSourceContextHolder.setDataSourceKey(key);
            return invocation.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceKey();
        }
    }

    private DS getDSAnnotation(Method method, Class<?> targetClass) {
        DS ds = AnnotationUtils.findAnnotation(method, DS.class);
        if (ds == null) {
            ds = AnnotationUtils.findAnnotation(targetClass, DS.class);
        }
        return ds;
    }
}
