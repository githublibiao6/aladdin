package com.aladdin.mis.omnipotent.love.service.impl;

import com.aladdin.mis.omnipotent.business.entity.Essay;
import com.aladdin.mis.omnipotent.love.dao.DateLogMapper;
import com.aladdin.mis.omnipotent.love.entity.DateLog;
<<<<<<< HEAD
import com.aladdin.mis.omnipotent.love.service.DateLogService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.PageEntity;
=======
import com.aladdin.mis.business.blog.entity.Essay;
import com.aladdin.mis.omnipotent.love.service.DateLogService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.PageEntity;
import com.aladdin.mis.common.string.utils.StringUtil;
>>>>>>> ad7b8372fb695547346b195f89a3479ae6cc4d85
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
        Integer id = m.save();
        return id  != null;
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
    public boolean remove(Integer id) {
        Essay mode = new Essay();
        mode.setId(id);
        return mode.delete();
    }

    @Override
    public DateLog detail(Integer id) {
        return null;
    }
}
