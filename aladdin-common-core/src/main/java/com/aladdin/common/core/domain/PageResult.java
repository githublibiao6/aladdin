package com.aladdin.common.core.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private long page;
    @JsonProperty("pageSize")
    private long limit;
    private long total;
    private long totalPages;
    private List<T> items;

    public PageResult() {
    }

    public PageResult(long page, long limit, long total, List<T> items) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.totalPages = (int) Math.ceil((double) total / limit);
        this.items = items;
    }
}
