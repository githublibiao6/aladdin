package com.aladdin.common.db.enums;

/**
 * 字段查询操作符枚举
 *
 * @author cles
 * @date 2026/04/30
 */
public enum FieldOperationEnumCode {

    EQ("eq", "="),
    NE("ne", "!="),
    GT("gt", ">"),
    GE("ge", ">="),
    LT("lt", "<"),
    LE("le", "<="),
    LK("lk", "like"),
    LLK("lLk", "like"),
    RlK("rlk", "like"),
    NK("nk", "not like"),
    NULL("null", "is null"),
    NOT_NULL("not null", "is not null");

    private String operation;
    private String symbol;

    FieldOperationEnumCode(String operation, String symbol) {
        this.operation = operation;
        this.symbol = symbol;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
