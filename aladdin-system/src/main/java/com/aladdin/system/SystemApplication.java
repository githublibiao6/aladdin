package com.aladdin.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 系统管理启动：" *
 * @author cles
 * @date 2026/05/08
 */
@SpringBootApplication(scanBasePackages = {"com.aladdin.system", "com.aladdin.common"})
@EnableDiscoveryClient
@MapperScan({"com.aladdin.system.dao"})
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
