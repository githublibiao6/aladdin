package com.aladdin.common.core.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class PageResult<T> implements Serializable {

    private int page;
    private int limit;
    private long total;
    private int totalPages;
    private List<T> items;

    public PageResult() {
    }

    public PageResult(int page, int limit, long total, List<T> items) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.totalPages = (int) Math.ceil((double) total / limit);
        this.items = items;
    }
}
