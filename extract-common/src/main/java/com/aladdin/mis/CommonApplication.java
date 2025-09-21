package com.aladdin.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动主类
 * @author cles
 */
@MapperScan(basePackages = {"com.aladdin.mis.*.mapper.*"})
@ComponentScan(basePackages = {"com.aladdin.mis.*.mapper.*"})
@SpringBootApplication
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
