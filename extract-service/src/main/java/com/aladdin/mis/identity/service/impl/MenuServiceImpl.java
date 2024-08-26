package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.MenuDao;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.service.BeApplicationService;
import com.aladdin.mis.manager.bean.Menu;
import com.aladdin.mis.pagehelper.entity.qo.MenuQo;
import com.aladdin.mis.identity.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 菜单service
* @Description
* @MethodName  MenuServiceImpl
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class MenuServiceImpl extends GlobalServiceImpl<Menu> implements MenuService {

    @Autowired
    private MenuDao dao;

    @Autowired
    private BeApplicationService applicationService;

    @Override
    public List<Menu> list() {
        return dao.list2();
    }

    @Override
    public PageInfo<Menu> page(MenuQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        return new PageInfo<>(dao.list(qo));
    }

    /**
     * 功能描述：
     *  < 获取菜单树形列表 >
     * @Description: pageList
     * @Author: cles
     * @Date: 2020/6/23 23:00
     * @param qo 参数1
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    @Override
    public List<Menu> tree(MenuQo qo) {
        List<Menu> list = dao.list(qo);
        convertMenuTree(list, -1);
        List<Menu> result = list.stream().filter(s-> -1 == s.getParent()).collect(Collectors.toList());
        List<Menu> data = dao.getAppList();
        // 应用列表
        data.forEach(t->{
            List<Menu> children = new ArrayList<>();
            result.forEach(m->{
                if(m.getAppId().equals(t.getAppId())){
                    children.add(m);
                }
            });
            if(children.size() > 0){
                children.get(0).setSortIndex(0);
                children.get(children.size()-1).setSortIndex(1);
                t.setChildren(children);
                t.setHasChildren(true);
            }else {
                t.setHasChildren(false);
            }
        });
        return data;
    }

    private void convertMenuTree(List<Menu> list,  Integer pid){
        list.forEach(t->{
            List<Menu> children = new ArrayList<>();
            if(pid.equals(t.getParent())){
                for (Menu record : list) {
                    if(record.getParent().equals(t.getId())){
                        children.add(record);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertMenuTree(list, t.getId());
                    });
                    children.get(0).setSortIndex(0);
                    children.get(children.size()-1).setSortIndex(1);
                    t.setChildren(children);
                    t.setHasChildren(true);
                }else {
                    t.setHasChildren(false);
                }
            }
        });
    }

    @Override
    public boolean add(Menu menu) {
        menu.setSortNum(1);
        Integer sortNum = dao.getMaxSortNumByParent(menu.getParent());
        if(sortNum != null){
            menu.setSortNum(sortNum + 1);
        }
        insertSelective(menu);
        return true;
    }

    @Override
    public Menu findById(Integer menuId){
        Menu m = detailQuery(menuId);
        System.err.println(m);
        return m;
    }

    @Override
    public Set<String> queryByRoles(Set<String> roles) {
        Set<String> set = new HashSet<>();
        List<Menu> menus = dao.queryByRoles(roles);
        menus.forEach(t->{
            set.add(t.getUrl());
        });
        return set;
    }

    @Override
    public boolean remove(String menuId){
        boolean flag = true;
        int num = dao.remove(menuId);
        if(num > 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean update(Menu menu ){
        return updateSelective(menu);
    }

    /**
    * @Description: 根据角色code获取菜单
    * @Param: [code]
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
    * @Author: cles
    * @Date: 2020/4/15 23:34
    */
    @Override
    public List<Menu> queryByRoleId(String code) {
        return dao.queryByRoleId(code);
    }

    @Override
    public Menu getByAppId(Integer appId) {
        return dao.getByAppId(appId);
    }

    @Override
    public int getMaxSortNumByApp() {
        return dao.getMaxSortNumByApp();
    }

    @Override
    public boolean moveUp(Integer id) {
        Menu menu = detailQuery(id);
        int sortNum = menu.getSortNum();
        if(sortNum == 1){
            return true;
        }
        menu.setSortNum(sortNum - 1);
        Menu upMenu  = dao.getUpMenu(menu.getParent() , sortNum);
        upMenu.setSortNum(sortNum);
        update(upMenu);
        update(menu);
        return true;
    }

    @Override
    public boolean moveDown(Integer id) {
        Menu menu = detailQuery(id);
        int sortNum = menu.getSortNum();
        menu.setSortNum(sortNum + 1);
        Menu downMenu  = dao.getDownMenu(menu.getParent() , sortNum);
        if(downMenu == null){
            return true;
        }
        downMenu.setSortNum(sortNum);
        update(downMenu);
        update(menu);
        return true;
    }

    /**
     * @Description 获取菜单（用户权限）
     * @MethodName listMenu
     * @return List<Role>
     * @author lb
     * @date 2018年8月21日 下午9:55:31
     *
     */
    @Override
    public List<Menu> list(MenuQo qo) {
        // 如果应用为空，获取当前应用的appId
        if(qo.getAppId() == null){
            BeApplication app = applicationService.getByKeyAndSecret();
            if(app == null){
                return new ArrayList<>();
            }
            qo.setAppId(app.getId());
        }
        List<Menu> list = dao.list(qo);
        // todo 根据用户权限获取菜单
        if(!list.isEmpty()){
            handleList(list);
        }
        return list;
    }

    private void handleList(List<Menu> list){
        list.forEach(t->{
            t.setHasChildren(false);
            for (Menu m : list) {
                if (t.getId().equals(m.getParent())) {
                    t.setHasChildren(true);
                    return;
                }
            }
        });
    }

    @Override
    public List<Menu> getByParentId(Integer parentId, Integer appId) {
        MenuQo qo = new MenuQo();
        qo.setShow(1);
        List<Menu> list = dao.list(qo);
        if(appId == null){
            parentId = -1;
        }
        convertMenuTree(list, parentId);
        Integer finalParentId = parentId;
        return list.stream().filter(s-> finalParentId.equals(s.getParent())).collect(Collectors.toList());
    }
}
