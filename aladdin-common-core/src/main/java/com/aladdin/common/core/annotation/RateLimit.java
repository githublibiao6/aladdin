package com.aladdin.common.core.annotation;

import java.lang.annotation.*;

/**
 * 接口限流注解
 *
 * @author cles
 * @date 2026/05/06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    int count() default 100;

    int period() default 1;

    LimitType limitType() default LimitType.IP;

    String message() default "请求过于频繁，请稍后再试";

    enum LimitType {
        IP,
        USER,
        GLOBAL
    }
}
