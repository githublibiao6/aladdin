package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.Dept;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.dao.DeptDao;
import com.apps.omnipotent.manager.dao.RoleDao;
import com.apps.omnipotent.manager.service.DeptService;
import com.apps.omnipotent.manager.service.RoleService;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class DeptServiceImpl extends GlobalServiceImpl implements DeptService {

    @Autowired
    DeptDao dao;

    @Override
    public PageEntity page(PageEntity entity) {
        List<Dept> page = dao.list();
        return null;
    }

    /**
     * 获取全部角色
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    @Override
    public List<Dept> list() {
        return dao.list();
    }


    @Override
    public boolean add(Dept m) {
        String id = m.save();
        return !StringUtil.isBlank(id);
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        // todo 根据admin查询角色
        return null;
    }

    @Override
    public boolean remove(String id){
        Dept d = new Dept();
        d.setId(id);
        return d.delete();
    }
    @Override
    public boolean update(Dept m){
        return m.update();
    }

    @Override
    public Dept findById(String menuId){
        return dao.findById(menuId);
    }
}
