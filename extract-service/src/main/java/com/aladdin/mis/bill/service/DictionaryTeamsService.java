package com.aladdin.mis.bill.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.DictionaryTeams;
import com.aladdin.mis.manager.qo.DictionaryQo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public interface DictionaryTeamsService  extends GlobalService<DictionaryTeams> {

    /**
     * 功能描述：
     *  < 分页获取字典项 >
     * @Description: page
     * @param qo
     * @Author: cles
     * @Date: 2020/6/23 23:02
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    PageInfo<DictionaryTeams> page(DictionaryQo qo);

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
    boolean remove(Integer id);

    /**
     * 根据code获取 字典列表
     * value - text 键值对
     * @param code 字典code
     * @return
     */
    Map<String, String> getTeamsByCode(String code);

}
