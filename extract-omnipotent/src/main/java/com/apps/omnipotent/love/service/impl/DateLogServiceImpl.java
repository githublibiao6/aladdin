package com.apps.omnipotent.love.service.impl;

import com.apps.omnipotent.business.entity.Essay;
import com.apps.omnipotent.love.dao.DateLogMapper;
import com.apps.omnipotent.love.entity.DateLog;
import com.apps.omnipotent.love.service.DateLogService;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DateLogServiceImpl extends GlobalServiceImpl implements DateLogService {

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
        String id = m.save();
        return !StringUtil.isBlank(id);
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
        return m.update();
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
    public boolean remove(String id) {
        Essay mode = new Essay();
        mode.setId(id);
        return mode.delete();
    }

    @Override
    public DateLog detail(String id) {
        return null;
    }
}
