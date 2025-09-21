package com.aladdin.mis.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主类
 * @author cles
 */
@SpringBootApplication()
@MapperScan(basePackages = {"com.aladdin.mis.*.mapper"})
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
