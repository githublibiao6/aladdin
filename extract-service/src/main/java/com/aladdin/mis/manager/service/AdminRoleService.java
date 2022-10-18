package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.AdminRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 管理员service接口
* @Author: cles
* @Date: 2020/4/28 23:13
*/
public interface AdminRoleService extends GlobalService<AdminRole> {

    List<AdminRole> getRoleByAdmin(Integer adminId);

    void setRoles(Integer adminId, String roles);
}
