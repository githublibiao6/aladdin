package com.aladdin.mis.bill.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.system.service.AdminRoleService;
import com.aladdin.mis.dao.manager.AdminRoleDao;
import com.aladdin.mis.manager.bean.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * admin service
 * @author lb
 * @date 2018年6月5日 下午8:55:47
 */
@Service
public class AdminRoleServiceImpl extends GlobalServiceImpl<AdminRole> implements AdminRoleService {

    @Autowired
    private AdminRoleDao dao;

    @Override
    public List<AdminRole> getRoleByAdmin(Integer adminId) {
        return dao.getRoleByAdmin(adminId);
    }

    @Override
    public void setRoles(Integer adminId, String roles) {
        dao.removeByAdmin(adminId);
        if(roles != null && !roles.isEmpty()){
            String[] roleArr = roles.split(",");
            for (String s : roleArr) {
                AdminRole adminRole = new AdminRole();
                adminRole.setAdminId(adminId);
                adminRole.setRoleId(Integer.parseInt(s));
                insert(adminRole);
            }
        }
    }
}
