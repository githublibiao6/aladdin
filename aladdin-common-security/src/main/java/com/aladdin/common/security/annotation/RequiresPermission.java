package com.aladdin.common.security.annotation;

import java.lang.annotation.*;

/**
 * 权限校验注解
 *
 * @author cles
 * @date 2026/05/06
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresPermission {

    String value();

    Logical logical() default Logical.AND;

    enum Logical {
        AND, OR
    }
}
