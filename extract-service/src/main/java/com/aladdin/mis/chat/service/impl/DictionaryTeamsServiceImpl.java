package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.DicTeamsDao;
import com.aladdin.mis.chat.manager.bean.DictionaryTeams;
import com.aladdin.mis.chat.manager.qo.DictionaryQo;
import com.aladdin.mis.chat.service.DictionaryTeamsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public PageInfo<DictionaryTeams> page(DictionaryQo qo) {
        Integer page = qo.getPage();
        Integer limit = qo.getLimit();
        page = page == null ? 0 : page;
        limit = limit == null ? 10 : limit;
        Integer dicId = qo.getDicId();
        List<DictionaryTeams> list = dao.listTeamsByDicId(dicId);
        PageHelper.offsetPage(page, limit);
        return new PageInfo<>(list);
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

    @Override
    public Map<String, String> getTeamsByCode(String code) {
        List<DictionaryTeams> list = dao.listTeamsByDicCode(code);
        Map<String, String> data = new HashMap<>(16);
        list.forEach(t->{
            data.put(t.getDicValue(), t.getDicText());
        });
        return data;
    }

    public List<DictionaryTeams> listTeamsByDicId(Integer id) {
        return dao.listTeamsByDicId(id);
    }
}
