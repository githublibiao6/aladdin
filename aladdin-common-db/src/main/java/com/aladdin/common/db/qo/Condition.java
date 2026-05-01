package com.aladdin.common.db.qo;

import com.aladdin.common.db.enums.FieldOperationEnumCode;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用查询条件
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class Condition {

    private Integer page;

    private Integer limit;

    private List<String> columns = new ArrayList<>();

    private List<FieldCondition> fieldConditions = new ArrayList<>();

    private Map<String, List<FieldCondition>> orConditions = new HashMap<>();

    private List<OrderCondition> orderConditions = new ArrayList<>();

    public Condition addExpression(String field, Object value) {
        fieldConditions.add(FieldCondition.newInstance().addExpression(field, value));
        return this;
    }

    public Condition addExpression(String field, String operation, Object value) {
        fieldConditions.add(FieldCondition.newInstance().addExpression(field, operation, value));
        return this;
    }

    public Condition addOrderExpression(String orderField, String orderType) {
        orderConditions.add(OrderCondition.newInstance().addOrderExpression(orderField, orderType));
        return this;
    }

    public Condition addOrExpression(String type, String field, Object value) {
        FieldCondition fieldCondition = FieldCondition.newInstance().addExpression(field, value);
        return handleOr(type, fieldCondition);
    }

    public Condition addOrExpression(String type, String field, String operation, Object value) {
        FieldCondition fieldCondition = FieldCondition.newInstance().addExpression(field, operation, value);
        return handleOr(type, fieldCondition);
    }

    private Condition handleOr(String type, FieldCondition fieldCondition) {
        if (orConditions.get(type) == null || orConditions.get(type).isEmpty()) {
            List<FieldCondition> list = new ArrayList<>();
            list.add(fieldCondition);
            orConditions.put(type, list);
        } else {
            orConditions.get(type).add(fieldCondition);
        }
        return this;
    }

    public Condition setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Condition setPage(Integer page) {
        this.page = page;
        return this;
    }

    public static Condition newInstance() {
        return new Condition();
    }
}
