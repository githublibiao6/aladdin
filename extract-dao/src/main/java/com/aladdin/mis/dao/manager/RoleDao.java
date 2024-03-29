package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单dao
* @Description
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
@Component
public interface RoleDao {

    /**
     * 功能描述：
     *  < 获取全部角色 >
     * @Description: list
     * @Author: cles
     * @Date: 2020/7/6 22:17
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Role>
     * @version: 1.0.0
     */
    @Select("select t.* from be_role t where sys005 = 1 ")
    List<Role> list();

    /**
     * 功能描述：
     *  < 根据主键获取数据 >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/7/6 22:17
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Role
     * @version: 1.0.0
     */
    Role findById(Integer id);

    /**
     * 根据用户获取用户的角色
     * @param id 用户主键
     * @return list
     */
    @Select("select * from be_role where id in (select t.role_id from be_admin_role t where sys005 = 1 and admin_id=#{id} ) and sys005 = '1'")
    List<Role> queryRolesByUserId(Integer id);
}
