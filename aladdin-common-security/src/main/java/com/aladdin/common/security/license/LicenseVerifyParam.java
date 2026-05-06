package com.aladdin.common.security.license;

import lombok.Data;

/**
 * License校验参数
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class LicenseVerifyParam {

    private String subject;

    private String publicAlias;

    private String storePass;

    private String licensePath;

    private String publicKeysStorePath;
}
