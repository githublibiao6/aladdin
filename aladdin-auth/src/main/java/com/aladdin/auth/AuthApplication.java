package com.aladdin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(
        scanBasePackages = {"com.aladdin.auth", "com.aladdin.system", "com.aladdin.common"},
        exclude = {
                org.redisson.spring.starter.RedissonAutoConfiguration.class
        }
)
@EnableDiscoveryClient
@MapperScan({"com.aladdin.system.dao"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
