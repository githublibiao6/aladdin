package com.apps.omnipotent.manager.service;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.dao.DicDao;
import com.apps.omnipotent.manager.dao.DicTeamsDao;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
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
public interface DictionaryTeamsService {


    /**
     * 功能描述：
     *  < 分页获取字典项 >
     * @Description: page
     * @param dicId
     * @param entity
     * @Author: cles
     * @Date: 2020/6/23 23:02
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    PageEntity page(String dicId, PageEntity entity);
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
    boolean add(DictionaryTeams m);

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
    boolean update(DictionaryTeams m);

    /**
     * 功能描述：
     *  < 根据id删除字典>
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:19
     * @param id 字典主键
     * @return: boolean
     * @version: 1.0.0
     */
    boolean remove(String id);

}
