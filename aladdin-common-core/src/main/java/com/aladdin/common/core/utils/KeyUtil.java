package com.aladdin.common.core.utils;

import java.util.UUID;

/**
 * 密钥生成工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class KeyUtil {

    private KeyUtil() {
    }

    public static String getUUIDKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
