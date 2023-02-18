package com.aladdin.mis.manager.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.Dictionary;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 字典 Service
 * @author lb
 *
 */
public interface DictionaryService extends GlobalService<Dictionary> {

    /**
     * 功能描述：
     *  <获取全部字典>
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/18 0:32
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Dictionary>
     * @version: 1.0.0
     */
    List<Dictionary> list();

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
    boolean add(Dictionary m);

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
    boolean update(Dictionary m);

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
     * 根据dictKey获取字典数据
     * @param dictKey
     * @return
     */
    Map<String, JSONObject> queryDictByCode(String dictKey);

    /**
     * 获取所有的字典
     * @return
     */
    Map<String, JSONObject> loadAllDictionary();
}
