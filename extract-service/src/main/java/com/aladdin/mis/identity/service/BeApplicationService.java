package com.aladdin.mis.identity.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import com.github.pagehelper.PageInfo;

/**
 * BeApplicationService
 * @author cles
 * @date 2024-08-21 03:21:11
*/
public interface BeApplicationService extends GlobalService<BeApplication>  {

    /**
     * 功能描述：
     *  < 分页 >
     * @Description: page
     * @Author: cles
     * @Date: 2020/7/1 23:51
     * @param qo 参数1
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    PageInfo<BeApplicationVo> page(BeApplicationQo qo);

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
    boolean add(BeApplication m);

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
    boolean update(BeApplication m);

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

    /**
     * 根据key和secret获取应用
     * @return
     */
    BeApplication getByKeyAndSecret();
}
