package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.bean.Dept;
import com.aladdin.mis.omnipotent.manager.dao.DeptDao;
import com.aladdin.mis.omnipotent.manager.service.DeptService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.PageEntity;
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
        Integer id = m.save();
        return id  != null;
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        // todo 根据admin查询角色
        return null;
    }

    @Override
    public boolean remove(Integer id){
        Dept d = new Dept();
        d.setId(id);
        return d.delete();
    }
    @Override
    public boolean update(Dept m){
        return m.update();
    }

    @Override
    public Dept findById(Integer menuId){
        return dao.findById(menuId);
    }
}
