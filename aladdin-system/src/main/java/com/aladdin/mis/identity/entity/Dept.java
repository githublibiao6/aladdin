package com.aladdin.mis.identity.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

import java.util.List;

/**
 * 部门 ："
 *
 * @author lb
 */
@Table("be_dept")
@Data
public class Dept extends GlobalModel {

    /**
     * 父节："
     */
    private Integer parent;

    /**
     * 编号
     */
    private String code;

    /**
    * 部门名称
     */
    private String name;

    /**
     * 说明
     */
    private String comments;

    /**
     * 应用主键
     */
    @TableField("app_id")
    private Integer appId;

    @TableField(exist = false)
    private Integer deptId;

    @TableField(exist = false)
    private String parentName;

    @TableField(exist = false)
    private List<Dept> children;

    @TableField(exist = false)
    private boolean hasChildren;

    @TableField(exist = false)
    private String menus;

}
