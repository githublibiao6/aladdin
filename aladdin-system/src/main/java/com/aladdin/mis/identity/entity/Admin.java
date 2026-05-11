package com.aladdin.mis.identity.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 管理员实体类
 * @author lb
 * @date 2018："："4："下午10:33:42
 */
@Table("be_admin")
@Data
public class Admin extends GlobalModel {

    /**
     * 登录："
     */
    private String loginName;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 登陆密码
     */
    private String loginPassword;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 部门
     */
    private Integer deptId;

    /**
     * 管理员状："
     */
    private String status;

    /**
     * 说明
     */
    private String notes;

    /**
     * 盐："
     */
    private String salt;

    /**
     * 说明
     */
    @TableField(exist = false)
    private String roles;

    /**
     * 组织机构
     */
    @TableField(exist = false)
    private String deptName;
}
