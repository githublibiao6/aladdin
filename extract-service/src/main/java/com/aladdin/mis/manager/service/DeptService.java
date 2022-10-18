package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.manager.vo.DeptVo;
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
public interface DeptService extends GlobalService<Dept> {
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
    PageEntity page(PageEntity entity);
    /**
     * 功能描述：
     *  < 获取全部>
     * @Description: list
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Role>
     * @version: 1.0.0
     */
    List<DeptVo> list();


    List<DeptVo> treeList();
    /**
     * 功能描述：
     *  < 新增>
     * @Description: add
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(Dept m);
    /**
     * 功能描述：
     *  < 更新 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean update(Dept m);
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
    Set<String> getRolesByUserId(String id);

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
    Dept findById(Integer id);

    /**
     * 分页查询组织机构
     * @param qo 查询条件
     * @return page
     */
    PageInfo<DeptVo> paginate(DeptQo qo);

    /**
     * 保存组织机构
     * @param entity
     * @return
     */
    Dept save(Dept entity);

}
