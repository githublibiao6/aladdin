package com.aladdin.mis.system.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.system.service.DictionaryService;
import com.aladdin.mis.dao.manager.DicDao;
import com.aladdin.mis.manager.bean.Dictionary;
import com.aladdin.mis.manager.vo.DictVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictionaryServiceImpl extends GlobalServiceImpl<Dictionary> implements DictionaryService {

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
        return  insertSelective(m);
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
        return updateSelective(m);
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

        return deleteById(id);
    }

    @Override
    public  Map<String, JSONObject> queryDictByCode(String dictKey) {
        if(dictKey == null || dictKey.isEmpty()){
            return null;
        }
        // 后续改为从缓存中获取
        String[] array = dictKey.split(",");
        List<DictVo> list = dao.queryDictByCode(array);

        return handleDict(list);
    }

    @Override
    public  Map<String, JSONObject> loadAllDictionary() {

        List<DictVo> list = dao.queryAllDictionary();
        return handleDict(list);
    }

    /**
     * 处理字典合集
     * @param list
     * @return
     */
    private Map<String, JSONObject> handleDict(List<DictVo> list){
        Map<String, JSONObject> data = new HashMap<>();
        Map<String, List<DictVo>> map = list.stream().collect(Collectors.groupingBy(DictVo::getCode));
        map.forEach((k,v) -> {
            JSONObject o = new JSONObject();
            v.forEach(t->{
                o.put(t.getDicValue(), t.getDicText());
            });
            data.put(k, o);
        });
        return data;
    }
}
