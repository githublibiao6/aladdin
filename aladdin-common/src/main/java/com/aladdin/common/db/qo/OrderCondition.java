package com.aladdin.common.db.qo;

import lombok.Data;

/**
 * 排序条件
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class OrderCondition {

    private String orderField;

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
