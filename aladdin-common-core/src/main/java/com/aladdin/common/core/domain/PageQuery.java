package com.aladdin.common.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询参数
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class PageQuery implements Serializable {

    private int page = 1;

    private int limit = 10;

    private String keyWord;

    private String sortInfo;

    public int getOffset() {
        return (page - 1) * limit;
    }
}
