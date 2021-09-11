package com.aladdin.mis.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 管理员实体类
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("be_admin")
@Data
public class Admin extends GlobalModel {

    /**
     * 登录名
     */
    private String loginName;
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
     * 说明
     */
    private String notes;

    /**
     * 说明
     */
    @TableField(exist = false)
    private String roles;
}
