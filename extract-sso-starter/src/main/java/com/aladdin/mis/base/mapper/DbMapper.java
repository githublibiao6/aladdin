package com.aladdin.mis.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DbMapper {

    @Select("${sql}")
    List<Map<String, Object>> find(@Param("sql") String sql);

}

