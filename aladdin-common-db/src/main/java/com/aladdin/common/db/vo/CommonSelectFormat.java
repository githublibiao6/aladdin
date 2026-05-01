package com.aladdin.common.db.vo;

import lombok.Data;

import java.util.List;

/**
 * 通用下拉选择格式
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class CommonSelectFormat {

    private String value;

    private String label;

    private List<CommonSelectFormat> children;
}
