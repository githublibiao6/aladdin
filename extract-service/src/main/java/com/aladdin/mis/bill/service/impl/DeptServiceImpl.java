package com.aladdin.mis.bill.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.DeptDao;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.bill.service.DeptService;
import com.aladdin.mis.manager.vo.DeptVo;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
public class DeptServiceImpl extends GlobalServiceImpl<Dept> implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public PageEntity page(PageEntity entity) {
        List<DeptVo> page = dao.list();
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
    public List<DeptVo> list() {
        return dao.list();
    }

    @Override
    public List<DeptVo> treeList() {
        List<DeptVo> list = list();
        list.forEach(t->{t.setLabel(t.getName());});
        convertDeptTree(list, -1);
        return list.stream().filter(s-> -1 == s.getParent()).collect(Collectors.toList());
    }

    private void convertDeptTree(List<DeptVo> list, Integer pid){
        list.forEach(t->{
            List<DeptVo> children = new ArrayList<>();
            if(pid.equals(t.getParent())){
                for (Dept record : list) {
                    if(record.getParent().equals(t.getId())){
                        DeptVo vo = (DeptVo) record;
                        vo.setParentName(t.getName());
                        children.add(vo);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertDeptTree(list, t.getId());
                    });
                    t.setChildren(children);
                    t.setHasChildren(true);
                }else {
                    t.setHasChildren(false);
                }
            }
        });
    }

    @Override
    public boolean add(Dept m) {
        Integer id = insert(m);
        return id  != null;
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        // todo 根据admin查询角色
        return null;
    }

    @Override
    public boolean remove(Integer id){
        return deleteById(id);
    }
    @Override
    public boolean update(Dept m){
        return updateSelective(m);
    }

    @Override
    public Dept findById(Integer menuId){
        return dao.findById(menuId);
    }

    @Override
    public PageInfo<DeptVo> paginate(DeptQo qo) {
        return null;
    }

    @Override
    public Dept save(Dept entity) {
        return insertSelective(entity);
    }
}
