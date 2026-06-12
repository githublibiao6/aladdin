package com.aladdin.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.aladdin.file.config.FileProperties;

/**
 * 文件服务启动类
 *
 * @author cles
 * @date 2026/06/12
 */
@SpringBootApplication(scanBasePackages = {"com.aladdin.file", "com.aladdin.common"})
@EnableDiscoveryClient
@EnableConfigurationProperties(FileProperties.class)
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }
}
