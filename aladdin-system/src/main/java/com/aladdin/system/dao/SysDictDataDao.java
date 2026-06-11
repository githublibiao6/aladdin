package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysDictData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysDictDataDao extends BaseDao<SysDictData> {

    @Select("SELECT d.* FROM sys_dict_data d " +
            "INNER JOIN sys_dict_type t ON d.dict_type_id = t.id " +
            "WHERE t.dict_type = #{dictType} AND d.sys005 = 1 " +
            "ORDER BY d.sort")
    List<SysDictData> selectByDictType(@Param("dictType") String dictType);
}
