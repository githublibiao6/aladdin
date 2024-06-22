package com.aladdin.mis.bill.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.AdminRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 管理员service接口
* @Author: cles
* @Date: 2020/4/28 23:13
*/
@Service
public interface AdminRoleService extends GlobalService<AdminRole> {

    /**
     * 根据管理员主键获取角色
     * @param adminId
     * @return
     */
    List<AdminRole> getRoleByAdmin(Integer adminId);

    /**
     * 给管理员设置角色
     * @param adminId
     * @param roles
     */
    void setRoles(Integer adminId, String roles);
}
