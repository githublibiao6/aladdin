package com.aladdin.mis.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BaseMapper {

    @Select("select 1 from dual")
    int find();
}
