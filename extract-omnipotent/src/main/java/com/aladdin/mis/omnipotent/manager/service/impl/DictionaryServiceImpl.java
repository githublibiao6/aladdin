package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.bean.Dictionary;
import com.aladdin.mis.omnipotent.manager.dao.DicDao;
<<<<<<< HEAD
import com.aladdin.mis.omnipotent.manager.service.DictionaryService;
=======
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
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DicDao dao;

    /**
    * @Description: 获取全部字典
    * @Param: []
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
    * @Author: cles
    * @Date: 2020/5/13 23:28
    */
    @Override
    public List<Dictionary> list(){
        return dao.listDictionary();
    }

    /**
    * @Description: 添加字典
    * @Param: [m]
    * @return: boolean
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    @Override
    public boolean add(Dictionary m) {
        Integer id = m.save();
        return id != null;
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
    public boolean update(Dictionary m) {
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
        Dictionary mode = new Dictionary();
        mode.setId(id);
        return mode.delete();
    }
}
