package com.aladdin.mis.base.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

//    @Select("select 1 from dual")
    void find();
}
