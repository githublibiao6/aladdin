package com.aladdin.mis.business.service;

import com.aladdin.mis.blog.entity.Essay;
import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public interface EssayService extends GlobalService<Essay> {

    /**
     * 分页
     * @param entity
     * @return
     */
    PageInfo<Essay> page(PageEntity entity) ;

    /**
     * 功能描述：
     *  <获取全部字典>
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
     * @version: 1.0.0
     */
    List<Essay> list();

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
    boolean add(Essay m);

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
    boolean update(Essay m);

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
    boolean remove(Integer id);

    /**
     * 功能描述：根据主键查询文章
     *  < >
     * @Description: detail
     * @Author: cles
     * @Date: 2020/8/26 23:27
     * @param id 参数1
     * @return: com.apps.omnipotent.business.entity.Essay
     * @version: 1.0.0
     */
    Essay detail(Integer id);
}
