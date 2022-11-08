package com.aladdin.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主类
 * @author cles
 */
//@EnableDiscoveryClient
@SpringBootApplication()
/*@SpringBootApplication(scanBasePackages = {"com.aladdin.mis.*.*"} )*/
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }


}
