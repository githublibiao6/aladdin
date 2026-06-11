package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysDictType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysDictTypeDao extends BaseDao<SysDictType> {

    @Select("SELECT * FROM sys_dict_type WHERE dict_type = #{dictType} AND sys005 = 1")
    SysDictType selectByDictType(@Param("dictType") String dictType);
}
