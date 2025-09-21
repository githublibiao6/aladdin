package com.aladdin.mis.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主类
 * @author jacklee
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.aladdin.mis.*.mapper"})
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
