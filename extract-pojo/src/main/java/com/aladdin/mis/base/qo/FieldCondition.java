package com.aladdin.mis.base.qo;
/*
 *  Created by cles on 2022/3/28 23:25
 */

import com.aladdin.mis.enums.FieldOperationEnumCode;
import lombok.Data;

/**
 * @author cles
 * @description: 基础查询类
 * @Date 2022/3/28 23:25
 * @version: 1.0.0
 */
@Data
public class FieldCondition {

    /**
     * 字段
     */
    private String field;

    /**
     * 过滤符号
     */
    private String op;

    /**
     * 过滤值
     */
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
