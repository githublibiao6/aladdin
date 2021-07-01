package com.aladdin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主类
 * @author 李标
 */
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = {"com.aladdin.system.**.mapper"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
//
//    @Bean
//    public DatabaseIdProvider getDatabaseIdProvider() {
//        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
//        Properties properties = new Properties();
//        properties.setProperty("Oracle", "oracle");
//        properties.setProperty("MySQL", "mysql");
//        databaseIdProvider.setProperties(properties);
//        return databaseIdProvider;
//    }

}
