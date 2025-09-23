package com.aladdin.mis.common.utils;
/*
 *  Created by cles on 2022/10/14 21:46
 */

/**
 * @author cles
 * @description: 处理shiroRealm 注入service的问题
 * @Date 2022/10/14 21:46
 * @version: 1.0.0
 */

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring加载时候，注入的bean 的顺序是 先是Lisener 然后是 Filter 最后是 Servlet
 * 因此如果在过滤器或者监听器里面注入service等会是空，因为在过滤器或者监听器加载的时候
 * Servlet，service等还没有加载，因此是空的，所以就手动注入

 */
@Component
public class SpringBeanFactoryUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext)
            throws BeansException {
        if (SpringBeanFactoryUtils.applicationContext == null) {
            SpringBeanFactoryUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据名称（@Resource注解）
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 根据类型（@Autowired）
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
