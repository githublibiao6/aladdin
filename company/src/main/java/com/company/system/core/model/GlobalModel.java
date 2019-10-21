package com.company.system.core.model;

import java.util.Date;
import java.util.Map;

/**
 * 基础model(默认参数)
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
public class GlobalModel extends Tmodel {
    private String createUser; // 创建人
    private String createDept; // 创建人部门
    private Date createTime; // 创建时间
    private String modifyUser; // 修改人
    private String modifyDept; // 修改人部门
    private Date modifyTime; // 修改时间
    private String effectiveFlag;// 有效标志
    private String deleteFlag; // 删除标记
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getCreateDept() {
        return createDept;
    }
    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getModifyUser() {
        return modifyUser;
    }
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    public String getModifyDept() {
        return modifyDept;
    }
    public void setModifyDept(String modifyDept) {
        this.modifyDept = modifyDept;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getEffectiveFlag() {
        return effectiveFlag;
    }
    public void setEffectiveFlag(String effectiveFlag) {
        this.effectiveFlag = effectiveFlag;
    }
    public String getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
