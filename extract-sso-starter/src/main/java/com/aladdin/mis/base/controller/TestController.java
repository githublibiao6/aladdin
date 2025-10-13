package com.aladdin.mis.base.controller;

import com.aladdin.mis.base.entity.Person;
import com.aladdin.mis.base.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/doTest")
    @ResponseBody
    public String doTest(){
        Person person = new Person();
        person.setId(1);
        person.setName("zs");
        personService.updateById(person);
        System.err.println("doTest");
        return "doTest";
    }
}
