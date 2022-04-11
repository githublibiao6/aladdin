package com.aladdin.mis.base.qo;
/*
 *  Created by cles on 2022/3/28 23:25
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cles
 * @description: 基础查询类
 * @Date 2022/3/28 23:25
 * @version: 1.0.0
 */
@Data
public class QueryCondition {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 数量
     */
    private Integer limit;

    /**
     * 查询字段
     */
    private List<String> columns = new ArrayList<>();

    /**
     * 字段过滤
     */
    private List<FieldCondition> fieldConditions = new ArrayList<>();

    /**
     * 字段or过滤
     */
    private Map<String, List<FieldCondition>> orConditions = new HashMap<>();

    /**
     * 排序字段
     */
    private List<OrderCondition> orderConditions = new ArrayList<>();


    public QueryCondition addExpression(String field, Object value) {
        fieldConditions.add(FieldCondition.newInstance().addExpression(field, value));
        return this;
    }

    public QueryCondition addExpression(String field, String operation, Object value) {
        fieldConditions.add(FieldCondition.newInstance().addExpression(field,operation, value));
        return this;
    }

    public QueryCondition addOrderExpression(String orderField, String orderType) {
        orderConditions.add(OrderCondition.newInstance().addOrderExpression(orderField,orderType));
        return this;
    }

    public QueryCondition setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public QueryCondition setPage(Integer page) {
        this.page = page;
        return this;
    }

    public static QueryCondition newInstance() {
        return new QueryCondition();
    }
}
