package com.aladdin.mis.system.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.Role;
import com.aladdin.mis.manager.bean.RoleMenu;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
* @Description: 角色service
* @Author: cles
* @Date: 2020/4/15 23:48
*/
public interface RoleService extends GlobalService<Role> {

    /**
     * 功能描述：
     *  < 分页获取 >
     * @Description: page
     * @Author: cles
     * @Date: 2020/7/6 0:06
     * @param entity 参数1
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    PageInfo<Role> page(PageEntity entity);

    /**
     * 功能描述：
     *  < 获取全部>
     * @Description: list
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Role>
     * @version: 1.0.0
     */
    List<Role> list();

    /**
     * 功能描述：
     *  < >
     * @Description: findByRoleId
     * @Author: cles
     * @Date: 2020/7/8 23:37
     * @param roleId 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Role>
     * @version: 1.0.0
     */
    List<RoleMenu> findByRoleId(Integer roleId);

    /**
     * 功能描述：
     *  < 新增>
     * @Description: add
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param role 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(Role role);

    /**
     * 功能描述：
     *  < 更新 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param role 参数1
     * @param menus 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean update(Role role, String menus);

    /**
     * 功能描述：
     *  < 删除 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param id 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean remove(Integer id);

    /**
     * 功能描述：
     *  < 根据人员获取角色 >
     * @Description: getRolesByUserId
     * @Author: cles
     * @Date: 2020/7/6 0:08
     * @param id 参数1
     * @return: java.util.Set<java.lang.String>
     * @version: 1.0.0
     */
    Set<String> getRolesByUserId(Integer id);

    /**
     * 功能描述：
     *  < 根据主键获取 >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/7/6 0:08
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Role
     * @version: 1.0.0
     */
    Role findById(Integer id);
}
