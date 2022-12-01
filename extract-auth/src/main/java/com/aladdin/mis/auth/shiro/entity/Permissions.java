package com.aladdin.mis.auth.shiro.entity;
/**
 * Created by cles on 2020/4/17 23:56
 */

import lombok.Data;

/**
 * @author cles
 * @description: 权限信息
 * @Auther cles
 * @Date 2020/4/17 23:56
 */
@Data
public class Permissions {

    public Permissions(String id,String permissionsName){
        this.id = id;
        this.permissionsName = permissionsName;
    }

    private String id;
    private String permissionsName;

}
