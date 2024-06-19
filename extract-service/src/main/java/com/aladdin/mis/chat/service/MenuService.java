package com.aladdin.mis.chat.service;


import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.chat.manager.bean.Menu;
import com.aladdin.mis.pagehelper.entity.qo.MenuQo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述：
 *  < 菜单service >
 * @Description:
 * @Author: cles
 * @Date: 2020/6/23 22:55
 * @return:
 * @version: 1.0.0
 */
public interface MenuService  extends GlobalService<Menu> {

    /**
     * 功能描述：
     *  < 获取所有 >
     * @Description: list
     * @Author: cles
     * @param qo
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    List<Menu> list(MenuQo qo);

    /**
     * 获取列表数据
     * @return
     */
    List<Menu> list();

    /**
     * 功能描述：
     *  < 获取所有 >
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    List<Map> listMap();

    /**
     * 功能描述：
     *  < 分页 >
     * @Description: pagelist
     * @Author: cles
     * @param qo
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    PageInfo<Menu> page(MenuQo qo);

    /**
     * 功能描述：
     *  < 分页 >
     * @Description: pagelist
     * @Author: cles
     * @param qo
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    List<Menu> tree(MenuQo qo);

    /**
     * 功能描述：
     *  < 新增菜单 >
     * @Description: add
     * @Author: cles
     * @Date: 2020/6/23 22:54
     * @param menu 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(Menu menu);

    /**
     * 功能描述：
     *  < 更新 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/7/7 23:27
     * @param menu 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean update(Menu menu);

    /**
     * 功能描述：
     *  < 删除 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/7/7 23:27
     * @param id 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean remove(String id);

    /**
     * 功能描述：
     *  < 根据主键查询 >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/7/7 23:27
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Menu
     * @version: 1.0.0
     */
    Menu findById(Integer id);

    /**
     * 根据角色获取 菜单
     * @param roles 角色集合
     * @return set
     */
    Set<String> queryByRoles(Set<String> roles);

    /**
     * 根据角色获取菜单
     * @param code
     * @return
     */
    List<Menu> queryByRoleId(String code);
}
