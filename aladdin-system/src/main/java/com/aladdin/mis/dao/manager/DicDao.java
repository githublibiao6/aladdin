package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Dictionary;
import com.aladdin.mis.manager.vo.DictVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface DicDao {

    /**
     * 获取全部dictionary
     * @return
     */
    @Select( "select * from be_dictionary m where m.sys005='1'")
    List<Dictionary> listDictionary();

    /**
     * 获取
     * @param dictKeys
     * @return
     */
    List<DictVo> queryDictByCode(@Param("dictKeys") String[] dictKeys);

    /**
     * 获取
     * @return
     */
    List<DictVo> queryAllDictionary();

    /**
     * 根据code查询记录
     * @param code
     * @return
     */
//    public Dict queryDictInfoByCode(@Param("code")String code,@Param("tableName")String tableName);

    /**
     * 修改dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int modifyDictInfo(@Param("dict")Dict dict,@Param("tableName")String tableName);

    /**
     * 添加dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int addDictInfo(@Param("dict")Dict dict,@Param("tableName")String tableName);

    /**
     * 删除dict
     * @param dict
     * @param tableName
     * @return
     */
//    public int deleteDictInfo(@Param("code")String code,@Param("tableName")String tableName);
}
