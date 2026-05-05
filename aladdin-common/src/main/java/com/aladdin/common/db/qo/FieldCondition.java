package com.aladdin.common.db.qo;

import com.aladdin.common.db.enums.FieldOperationEnumCode;
import lombok.Data;

/**
 * 字段查询条件
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class FieldCondition {

    private String field;

    private String op;

    private Object value;

    public FieldCondition addExpression(String field, Object value) {
        this.op = FieldOperationEnumCode.EQ.getOperation();
        setField(field);
        setValue(value);
        return this;
    }

    public FieldCondition addExpression(String field, String operation, Object value) {
        this.op = operation;
        addExpression(field, value);
        return this;
    }

    public static FieldCondition newInstance() {
        return new FieldCondition();
    }
}
