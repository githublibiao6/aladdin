package com.aladdin.mis.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.DeptDao;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.aladdin.mis.service.DeptService;
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
public class DeptServiceImpl extends GlobalServiceImpl<Dept> implements DeptService {

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
        Integer id = 0;
//        Integer id = m.save();
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
//        return d.delete();
        return false;
    }
    @Override
    public boolean update(Dept m){
//        return m.update();
        return false;
    }

    @Override
    public Dept findById(Integer menuId){
        return dao.findById(menuId);
    }
}
