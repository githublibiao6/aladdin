package com.apps.omnipotent.manager.bean;

import com.apps.omnipotent.system.global.entity.GlobalModel;

/**
 * 项目实体类
 * @author lb
 * @date 2018年6月24日 下午6:52:01
 */
public class Project extends GlobalModel {

    private String code; // 项目编码
    private String projectName; // 项目名
    private String projectAddress; // 项目地址
    private String leader;// 项目负责人
    private String notes; // 项目描述
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectAddress() {
        return projectAddress;
    }
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Override
    public String toString() {
        return "Admin [code=" + code + ", projectName=" + projectName + ", projectAddress=" + projectAddress
                + ", leader=" + leader + ", notes=" + notes + "]";
    }
    
}
