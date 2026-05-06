package com.aladdin.common.db.annotation;

import java.lang.annotation.*;

/**
 * 数据权限注解
 *
 * @author cles
 * @date 2026/05/06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {

    String tableName() default "";

    String deptAlias() default "d";

    String userAlias() default "u";

    String deptIdColumn() default "dept_id";
}
