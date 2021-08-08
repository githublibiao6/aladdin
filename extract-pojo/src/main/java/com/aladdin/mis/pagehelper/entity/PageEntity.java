package com.aladdin.mis.pagehelper.entity;

import lombok.Data;

import java.util.List;

/**
 *  分页实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
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
}
