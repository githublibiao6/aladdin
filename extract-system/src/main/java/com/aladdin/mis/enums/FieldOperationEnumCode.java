package com.aladdin.mis.enums;

/**
 * 字段查询过滤字符
 * @author libia
 */
public enum FieldOperationEnumCode {

    /**
     * 常见数据库关系操作符号
     */
    EQ("eq" ,"=") ,

    NE("ne" ,"!=") ,

    GT("gt" ,">") ,

    GE("ge" ,">=") ,

    LT("lt" ,"<") ,

    LE("le" ,"<=") ,

    LK("lk" ,"like"),

    LLK("lLk" ,"like"),

    RlK("rlk" ,"like"),

    NK("nk" ,"not like"),

    NULL("null" ,"is null"),

    NOT_NULL("not null" ,"is not null")

    ;

    private String operation;
    private String symbol;

    FieldOperationEnumCode(String operation, String symbol){
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
