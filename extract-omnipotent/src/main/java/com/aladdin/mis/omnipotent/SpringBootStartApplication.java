package com.aladdin.mis.omnipotent;


import com.aladdin.mis.OmApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 总的来说，SpringBootServletInitializer 的作用是让 Spring Boot 应用程序可以以 WAR 包的形式部署到外部的 Servlet 容器（如 Tomcat、Jetty 等），
 * 并提供一种简单的方式来配置外部 Servlet 容器。
 * @author cles
 */
@Deprecated
public class SpringBootStartApplication  extends SpringBootServletInitializer implements WebMvcConfigurer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OmApplication.class);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
