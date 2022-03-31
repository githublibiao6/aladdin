package com.aladdin.mis.base.qo;
/*
 *  Created by cles on 2022/3/28 23:25
 */

import lombok.Data;

/**
 * @author cles
 * @description: 基础查询类
 * @Date 2022/3/28 23:25
 * @version: 1.0.0
 */
@Data
public class OrderCondition {

    /**
     * 排序字段
     */
    private String orderField;

    /**
     * 过滤符号
     */
    private String orderType;


    public OrderCondition addOrderExpression(String orderField, String orderType) {
        this.orderField = orderField;
        this.orderType = orderType;
        return this;
    }

    public static OrderCondition newInstance() {
        return new OrderCondition();
    }
}
