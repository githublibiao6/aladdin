package com.company.manage.dict.bean;

/**
 * 字典对象 Entity
 * @author lb
 *
 */
public class DictObj {
	
    private String tableNameEng;// 英文表名
    private String tableNameChn;// 表名
    private String category;// 分类
    private String effectFlag;// 生效标志
    private String createUser;// 创建人
    private String createTime;// 创建时间
    private String modifyUser;// 修改人
    private String modifyTime;// 修改时间
    private String notes; // 说明
    public String getTableNameEng() {
        return tableNameEng;
    }
    public void setTableNameEng(String tableNameEng) {
        this.tableNameEng = tableNameEng;
    }
    public String getTableNameChn() {
        return tableNameChn;
    }
    public void setTableNameChn(String tableNameChn) {
        this.tableNameChn = tableNameChn;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getEffectFlag() {
        return effectFlag;
    }
    public void setEffectFlag(String effectFlag) {
        this.effectFlag = effectFlag;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getModifyUser() {
        return modifyUser;
    }
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    public String getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Override
    public String toString() {
        return "DictObj [tableNameEng=" + tableNameEng + ", tableNameChn=" + tableNameChn + ", category=" + category
                + ", effectFlag=" + effectFlag + ", createUser=" + createUser + ", createTime=" + createTime
                + ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", notes=" + notes + "]";
    }
    
}
