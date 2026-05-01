package com.aladdin.common.core.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger配置属性
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
@ConfigurationProperties(prefix = "aladdin.swagger")
public class SwaggerProperties {

    private boolean enabled = true;
    private String title = "Aladdin Platform API";
    private String description = "Aladdin企业级开发平台接口文档";
    private String version = "1.0.0";
    private String basePackage = "com.aladdin";
    private String contactName = "Aladdin";
    private String contactEmail = "";
    private String contactUrl = "";
}
