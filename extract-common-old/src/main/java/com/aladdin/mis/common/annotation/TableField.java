package com.aladdin.mis.common.annotation;
/**
 * Created by cles on 2025/5/31 14:24
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author cles
 * @Date 2025/5/31 14:24
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableField {

    String value() default "";

    boolean exist() default true;
}
