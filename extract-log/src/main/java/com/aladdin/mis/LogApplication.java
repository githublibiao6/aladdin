package com.aladdin.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志项目启动主类
 * @author 李标
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.aladdin.system.**.mapper"})
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }


}
