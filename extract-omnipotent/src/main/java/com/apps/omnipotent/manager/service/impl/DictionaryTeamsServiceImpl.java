package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.dao.DicTeamsDao;
import com.apps.omnipotent.manager.service.DictionaryTeamsService;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryTeamsServiceImpl extends GlobalServiceImpl implements DictionaryTeamsService{

    @Autowired
    private DicTeamsDao dao;

    @Override
    public PageEntity page(String dicId, PageEntity entity) {
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
    public boolean update(DictionaryTeams m) {
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
        DictionaryTeams mode = new DictionaryTeams();
        mode.setId(id);
        return mode.delete();
    }

    public List<DictionaryTeams> listTeamsByDicId(String id) {
        return dao.listTeamsByDicId(id);
    }
}
