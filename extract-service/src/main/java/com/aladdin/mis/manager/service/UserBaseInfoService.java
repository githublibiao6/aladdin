package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
public interface UserBaseInfoService extends GlobalService<UserBaseInfo> {


//    /**
//     * 功能描述：
//     *  < 分页 >
//     * @Description: page
//     * @Author: cles
//     * @Date: 2020/7/1 23:51
//     * @param entity 参数1
//     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
//     * @version: 1.0.0
//     */
//    PageInfo<UserBaseInfo> page(UserQo entity);

    /**
     * 功能描述：
     *  <获取全部数据>
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @param name 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
     * @version: 1.0.0
     */
    List<UserBaseInfo> list(String name);

    /**
     * 功能描述：
     *  <添加>
     * @Description: add
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(UserBaseInfo m);

    /**
     * 功能描述：
     *  < 更新 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/21 23:45
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean update(UserBaseInfo m);

    /**
     * 功能描述：
     *  < 根据id删除>
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:19
     * @param id 字典主键
     * @return: boolean
     * @version: 1.0.0
     */
    boolean remove(Integer id);
}
