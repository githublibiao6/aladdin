package com.aladdin.mis.omnipotent.love.service.impl;

import com.aladdin.mis.business.entity.Essay;
import com.aladdin.mis.dao.love.DateLogMapper;
import com.aladdin.mis.love.entity.DateLog;
import com.aladdin.mis.omnipotent.love.service.DateLogService;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
public class DateLogServiceImpl extends GlobalServiceImpl<DateLog> implements DateLogService {

    @Autowired
    private DateLogMapper dateLogMapper;

    @Override
    public PageEntity page(PageEntity entity) {
        List<DateLog> page = dateLogMapper.listDateLog();
        return null;
    }

    @Override
    public List<DateLog> list() {
        return dateLogMapper.listDateLog();
    }

    /**
    * @Description: 添加字典
    * @Param: [m]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    @Override
    public boolean add(DateLog m) {
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
    public boolean update(DateLog m) {
        insertSelective(m);
//        return m.update();
        return true;
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

    @Override
    public DateLog detail(Integer id) {
        return null;
    }
}
