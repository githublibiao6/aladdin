package com.company.manage.dict.bean;

/**
 * 字典 Entity
 * @author lb
 *
 */
public class Dict {
    
    private String code;// 编码
    private String name;// 名称
    private String effectiveFlag;// 生效标志
    private String createTime;// 创建时间
    private String notes; // 说明
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEffectiveFlag() {
        return effectiveFlag;
    }
    public void setEffectiveFlag(String effectiveFlag) {
        this.effectiveFlag = effectiveFlag;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Override
    public String toString() {
        return "Dict [code=" + code + ", name=" + name + ", effectiveFlag=" + effectiveFlag + ", createTime="
                + createTime + ", notes=" + notes + "]";
    }
    
}
