package com.aladdin.mis.common.license.user;
/*
 *  Created by cles on 2024/8/18 17:33
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LicenseCheckRunner implements ApplicationRunner {
    /**
     * 证书subject
     */
    @Value("${license.subject}")
    private String subject;

    /**
     * 公钥别称
     */
    @Value("${license.publicAlias}")
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    @Value("${license.storePass}")
    private String storePass;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("++++++++ 开始安装证书 ++++++++");
        LicenseVerifyParam param = new LicenseVerifyParam();
        param.setSubject(subject);
        param.setPublicAlias(publicAlias);
        param.setStorePass(storePass);
        Resource resource = new ClassPathResource("application.yml");
        String filePath = resource.getFile().getAbsolutePath();
        // 相对路径resources资源目录
        String resourcePath = filePath.replaceAll("\\\\target\\\\classes\\\\application.yml", "");
        resourcePath += "/src/main/resources/";
        // 证书地址
        param.setLicensePath(resourcePath + "license.lic");
        // 公钥地址
        param.setPublicKeysStorePath(resourcePath + "publicCerts.keystore");
        // 安装证书
        LicenseVerify licenseVerify = new LicenseVerify();
        licenseVerify.install(param);
        log.info("++++++++ 证书安装结束 ++++++++");
    }
}

