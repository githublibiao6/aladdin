package com.apps.omnipotent.manager.utils;
/**
 * Created by cles on 2020/5/13 23:38
 */

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.service.impl.DictionaryServiceImpl;
import com.apps.omnipotent.manager.service.impl.DictionaryTeamsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description: 字典工具类
 * @author cles
 * @Date 2020/5/13 23:38
 */
@Component
public class DictionaryUtils {
    @Autowired
    private DictionaryServiceImpl dicService;
    @Autowired
    private static DictionaryServiceImpl staticDicService;
    @Autowired
    private DictionaryTeamsServiceImpl dicTeamsService;
    @Autowired
    private static DictionaryTeamsServiceImpl staticDicTeamsService;

    /**
     * static 调用service的办法
     */
    @PostConstruct
    public void initBefore() {
        staticDicService = dicService;
        staticDicTeamsService = dicTeamsService;
    }

    public static void init(){
        List<Dictionary> list = staticDicService.list();
        list.forEach(dic->{
            List<DictionaryTeams> teams = staticDicTeamsService.listTeamsByDicId(dic.getId());
            LinkedHashMap<String,String > teamMap = new LinkedHashMap<>();
            teams.forEach(t->{
                teamMap.put(t.getDicValue(),t.getDicText());
            });
            map.put(dic.getCode(),teamMap);
        });
    }

    private static HashMap<String ,LinkedHashMap<String,String >> map = new HashMap<>();

    public void setDictionary(String key, LinkedHashMap<String,String > teams){
        map.put(key,teams);
    }
    public LinkedHashMap<String,String>  getDictionary(String key){
        return map.get(key);
    }

}
