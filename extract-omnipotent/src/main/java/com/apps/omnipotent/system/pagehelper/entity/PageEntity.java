package com.apps.omnipotent.system.pagehelper.entity;

import java.util.List;

/**
 *  分页实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
public class PageEntity {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页数量
     */
    private int limit;
    /**
     * 记录总数
     */
    private long total;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据
     */
    private List<?> items;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }
}
