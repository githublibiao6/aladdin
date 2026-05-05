package com.aladdin.common.core.enums;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author cles
 * @date 2026/04/30
 */
@Getter
public enum StatusEnum {

    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    private final int code;
    private final String desc;

    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
