package com.aladdin.mis.manager.bean;


import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

import java.util.List;

/**
 * 菜单model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
@Table("be_menu")
public class Menu extends GlobalModel {

    /**
     图标
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String menuText;
    /**
     *  地址
     */
    private String url;
    /**
     * 父级菜单
     */
    private Integer parent;
    /**
     * 级别
     */
    private String level;
    /**
     * 说明
     */
    private String notes;
    /**
     * 菜单类型
     */
    private String menuType;
    /**
     * 是否是一级菜单
     */
    private String main;
    /**
     * 是否有子节点
     */
    @TableField(exist = false)
    private boolean hasChildren;

    @TableField(exist = false)
    private List<Menu> children;

}
