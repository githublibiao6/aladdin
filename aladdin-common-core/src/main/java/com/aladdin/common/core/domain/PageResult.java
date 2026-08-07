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

    /**
     * 前端兼容字段：部分前端页面使用 res?.list 读取列表数据，
     * 这里通过 @JsonProperty 将 items 同时序列化为 list，
     * 使 res?.items 与 res?.list 均可正常工作。
     */
    @JsonProperty("list")
    public List<T> getList() {
        return items;
    }
}
