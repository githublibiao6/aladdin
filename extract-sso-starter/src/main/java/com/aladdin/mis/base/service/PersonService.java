package com.aladdin.mis.base.service;

import com.aladdin.mis.base.entity.Person;
import org.springframework.stereotype.Service;


public interface PersonService extends BaseService<Person>{


    void updatePerson(Person person);
}
