package com.aladdin.mis.base.service.impl;

import com.aladdin.mis.base.entity.Person;
import com.aladdin.mis.base.mapper.PersonMapper;
import com.aladdin.mis.base.service.PersonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonMapper, Person> implements PersonService {

    @Override
    public void updatePerson(Person person) {
        baseMapper.updatePerson(person);
    }
}
