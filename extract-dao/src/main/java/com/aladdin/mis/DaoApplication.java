package com.aladdin.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主类
 * @author 李标
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.aladdin.mis.dao","com.aladdin.mis.dao"})
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

}
