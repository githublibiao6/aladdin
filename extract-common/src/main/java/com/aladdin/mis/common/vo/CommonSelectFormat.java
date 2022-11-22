package com.aladdin.mis.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 通用下拉选择格式
 * @author cles
 */
@Data
public class CommonSelectFormat {

    private String value;

    private String label;

    private List<CommonSelectFormat> children;
}
