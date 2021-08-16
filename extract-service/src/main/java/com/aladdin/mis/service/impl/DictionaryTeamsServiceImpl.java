package com.aladdin.mis.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.DicTeamsDao;
import com.aladdin.mis.manager.bean.DictionaryTeams;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.aladdin.mis.service.DictionaryTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryTeamsServiceImpl extends GlobalServiceImpl<DictionaryTeams> implements DictionaryTeamsService {

    @Autowired
    private DicTeamsDao dao;

    @Override
    public PageEntity page(Integer dicId, PageEntity entity) {
        List<DictionaryTeams> pageMenus = dao.listTeamsByDicId(dicId);
        return null;
    }

    /**
     * @Description: 添加字典
     * @Param: [m]
     * @return: boolean
     * @Author: cles
     * @Date: 2020/6/3 23:43
     */
    @Override
    public boolean add(DictionaryTeams m) {
//        Integer id = m.save();
//        return id != null;
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
    public boolean update(DictionaryTeams m) {
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
        DictionaryTeams mode = new DictionaryTeams();
        mode.setId(id);
//        return mode.delete();
        return false;
    }

    public List<DictionaryTeams> listTeamsByDicId(Integer id) {
        return dao.listTeamsByDicId(id);
    }
}
