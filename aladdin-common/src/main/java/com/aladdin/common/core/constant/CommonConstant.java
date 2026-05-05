package com.aladdin.common.core.constant;

/**
 * 通用常量
 *
 * @author cles
 * @date 2026/04/30
 */
public interface CommonConstant {

    String UTF8 = "UTF-8";

    String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    String DATE_PATTERN = "yyyy-MM-dd";
    String TIME_PATTERN = "HH:mm:ss";

    int SUCCESS = 200;
    int FAIL = 500;

    int VALID_ENABLE = 1;
    int VALID_DISABLE = 0;

    int DELETE_FLAG = 0;
    int NORMAL_FLAG = 1;

    String DEFAULT_PASSWORD = "Abc1234567";

    String UPLOAD_ATTACHMENT_URL = "/staticFile/";
}
