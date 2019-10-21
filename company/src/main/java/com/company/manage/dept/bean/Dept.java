package com.company.manage.dept.bean;

import java.util.Date;

/**
 * 部门 类
 * 
 * @author lb
 */
public class Dept {

    private String code;// 编号
    private String name;// 部门名称
    private String createUser;// 创建人
    private Date createTime;// 创建时间
    private Date modifyUser;// 修改人
    private Date modifyTime;// 修改时间
    private String state;// 运营状态
    private String notes;// 说明
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
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getModifyUser() {
        return modifyUser;
    }
    public void setModifyUser(Date modifyUser) {
        this.modifyUser = modifyUser;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Override
    public String toString() {
        return "Dept [code=" + code + ", name=" + name + ", createUser=" + createUser + ", createTime=" + createTime
                + ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", state=" + state + ", notes=" + notes
                + "]";
    }
    
}
