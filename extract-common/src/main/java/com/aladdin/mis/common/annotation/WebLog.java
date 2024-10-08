package com.aladdin.mis.common.annotation;

import java.lang.annotation.*;

/**
 * 接口访问日志
 * @author cles
 *  Created by cles on 2021/8/12 22:32
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {
    String value() default "";
}
