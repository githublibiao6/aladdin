package com.apps.omnipotent.manager.bean;

import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.global.entity.GlobalModel;

/**
 * 管理员实体类
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("be_admin")
public class Admin extends GlobalModel {

    private String id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 登陆密码
     */
    private String loginPassword;
    /**
     * 部门
     */
    private String deptId;
    /**
     * 说明
     */
    private String notes;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginPassword() {
        return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getDeptId() {
        return deptId;
    }
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", deptId='" + deptId + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
