package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.bean.RoleMenu;
import com.aladdin.mis.omnipotent.manager.dao.RoleMenuMapper;
import com.aladdin.mis.omnipotent.manager.service.RoleMenuService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class RoleMenuServiceImpl extends GlobalServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuMapper mapper;


    @Override
    public boolean removeByRoleId(String roleId) {
        mapper.removeByRoleId(roleId);
        return true;
    }

    @Override
    public List<RoleMenu> findByRoleId(String roleId) {
        return mapper.findByRoleId(roleId);
    }
}
