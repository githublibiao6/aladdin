package com.apps.omnipotent.system.db.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cles on 2020/5/10 1:12
 * https://www.cnblogs.com/DFX339/p/11386722.html
 */
/**
 * 注解生命周期作用范围
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 *注解可以作用在参数或者方法上
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
public @interface DbChange {


}
