package com.aladdin.mis.omnipotent.manager.bean;

import com.aladdin.mis.omnipotent.system.core.Table;
import com.aladdin.mis.omnipotent.system.core.TableField;
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 字典 Entity
 * @author cles
 *
 */
@Table("be_dictionary")
public class Dictionary extends GlobalModel {

    /**
     * 主键
     */
    @TableField("id")
    private String id;
    /**
    * 编码
     */
    private String code;
    /**
     *  名称
     */
    private String name;
    /**
     *  说明
     */
    private String comments;
    /**
     * 创建者
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改者
     */
    @TableField("modify_user")
    private String modifyUser;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 生效标志
     */
    @TableField("effective_flag")
    private String effectiveFlag;
    /**
     * 删除标志
     */
    @TableField("delete_flag")
    private String deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
