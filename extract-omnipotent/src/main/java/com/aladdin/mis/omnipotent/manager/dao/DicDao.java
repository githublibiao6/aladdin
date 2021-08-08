package com.aladdin.mis.omnipotent.manager.dao;

import com.aladdin.mis.manager.bean.Dictionary;
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
    @Select( "select * from be_dictionary m where m.delete_flag='1'")
    List<Dictionary> listDictionary();

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
