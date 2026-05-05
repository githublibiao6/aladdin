package com.aladdin.common.core.enums;

import lombok.Getter;

/**
 * 删除标志枚举
 *
 * @author cles
 * @date 2026/04/30
 */
@Getter
public enum DeleteFlagEnum {

    NORMAL(1, "正常"),
    DELETED(0, "已删除");

    private final int code;
    private final String desc;

    DeleteFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
