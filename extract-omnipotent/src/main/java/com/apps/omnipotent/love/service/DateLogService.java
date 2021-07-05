package com.apps.omnipotent.love.service;

import com.apps.omnipotent.love.entity.DateLog;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
public interface DateLogService {

    PageEntity page(PageEntity entity) ;
    /**
     * 功能描述：
     *  <获取全部字典>
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
     * @version: 1.0.0
     */
    List<DateLog> list();

    /**
     * 功能描述：
     *  <添加字典>
     * @Description: add
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(DateLog m);

    /**
     * 功能描述：
     *  < 更新字典 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/21 23:45
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean update(DateLog m);

    /**
     * 功能描述：
     *  < 根据id删除字典>
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:19
     * @param id 主键
     * @return: boolean
     * @version: 1.0.0
     */
    boolean remove(String id);

    /**
     * 功能描述：根据主键查询文章
     *  < >
     * @Description: detail
     * @Author: cles
     * @Date: 2020/8/26 23:27
     * @param id 参数1
     * @return: com.apps.omnipotent.business.entity.DateLog
     * @version: 1.0.0
     */
    DateLog detail(String id);
}
