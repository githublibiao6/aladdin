package com.aladdin.mis.auth.bean.vo;

import lombok.Data;

import java.util.List;

/**
 * 通用下拉选择格式
 */
@Data
public class CommonSelectFormat {

    private String value;

    private String label;

    private List<CommonSelectFormat> children;
}
