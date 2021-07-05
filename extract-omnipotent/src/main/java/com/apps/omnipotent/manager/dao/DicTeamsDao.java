package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.bean.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典对象 Dao
 * @author lb
 *
 */
@Repository
public interface DicTeamsDao {

    /**
     * 功能描述：
     *  < 根据字典获取字典项 >
     * @Description: listTeamsByDicId
     * @Author: cles
     * @Date: 2020/6/23 23:24
     * @param id 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.DictionaryTeams>
     * @version: 1.0.0
     */
    @Select("select * from be_dictionary_teams where dic_id=#{id} order by sort asc")
    List<DictionaryTeams> listTeamsByDicId(@Param("id") String id);

    /**
     * 功能描述：
     *  < >
     * @Description: page
     * @Author: cles
     * @Date: 2020/6/23 23:05
     * @return: java.util.List<com.apps.omnipotent.manager.bean.DictionaryTeams>
     * @version: 1.0.0
     */
    @Select("select * from be_dictionary order by sort asc")
    List<DictionaryTeams> page();

    /**
     * 获取全部的字典对象
     * @return
     */
//    public List<DictObj> listDictObj();
}
