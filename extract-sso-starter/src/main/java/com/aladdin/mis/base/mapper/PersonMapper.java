package com.aladdin.mis.base.mapper;

import com.aladdin.mis.base.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {


    @Update("update person set name = #{name} where id #{id}")
    void updatePerson(Person person);

}
