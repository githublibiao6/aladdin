package com.company.manage.role.mode;

import com.company.system.core.model.GlobalModel;

/**
 * 菜单model
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
public class Role extends GlobalModel {


    private String id;
    private String code; //
    private String name; // 图标
    private String notes; // 菜单名称

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Role{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
