package com.aladdin.mis.omnipotent.business.service.impl;

import com.aladdin.mis.blog.entity.Essay;
import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.business.EssayDao;
import com.aladdin.mis.omnipotent.business.service.EssayService;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class EssayServiceImpl extends GlobalServiceImpl implements EssayService {

    @Autowired
    private EssayDao dao;

    @Override
    public PageInfo page(PageEntity entity) {
        PageHelper.offsetPage(entity.getPage(), entity.getLimit());
        return new PageInfo(dao.listEssay());
    }

    /**
    * @Description: 获取全部字典
    * @Param: []
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
    * @Author: cles
    * @Date: 2020/5/13 23:28
    */
    @Override
    public List<Essay> list(){
        return dao.listEssay();
    }

    /**
    * @Description: 添加字典
    * @Param: [m]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    @Override
    public boolean add(Essay m) {
//        Integer id = m.save();
//        return id  != null;
        return false;
    }

    /**
     * 功能描述：
     *  < 更新字典 >
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/21 23:47
     * @param m 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    @Override
    public boolean update(Essay m) {
//        return m.update();
        return false;
    }

    /**
     * 功能描述：
     *  < 根据主键删除字典 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:20
     * @param id 字典主键
     * @return: boolean
     * @version: 1.0.0
     */
    @Override
    public boolean remove(Integer id) {
        Essay mode = new Essay();
        mode.setId(id);
//        return mode.delete();
        return false;
    }

    /**
     * 功能描述：
     * @Description: detail
     * @Author: cles
     * @Date: 2020/8/26 23:39
     * @param id 参数1
     * @return: com.apps.omnipotent.business.entity.Essay
     * @version: 1.0.0
     */
    @Override
    public Essay detail(Integer id) {
        return dao.findById(id);
    }
}
