package com.company.manage.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.company.manage.dict.bean.Dict;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface DictDao {
    
    /**
     * 获取全部dict
     * @param tableNameEng
     * @return
     */
//    public List<Dict> listDict();
    
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
