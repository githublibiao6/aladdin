package com.company.manage.menu.mode;

import com.company.system.core.model.GlobalModel;

/**
 * 菜单model
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
public class Menu extends GlobalModel {
    private String menuId; //
    private String iconCls; // 图标
    private String menuText; // 菜单名称
    private String url; // 地址
    private String parent; // 父级菜单
    private String level; // 级别
    private String notes;// 说明
    private String menuType;//  菜单类型

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMenu_type() {
        return menuType;
    }

    public void setMenu_type(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "menuId='" + menuId + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", menuText='" + menuText + '\'' +
                ", url='" + url + '\'' +
                ", parent='" + parent + '\'' +
                ", level='" + level + '\'' +
                ", notes='" + notes + '\'' +
                ", menuType='" + menuType + '\'' +
                '}';
    }
}
