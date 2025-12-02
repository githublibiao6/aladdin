package com.aladdin.mis.base.controller;

import com.aladdin.mis.base.entity.Person;
import com.aladdin.mis.base.service.PersonService;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/doTest")
    @ResponseBody
    public String doTest(@RequestParam(defaultValue = "insert") String type){
        Person person = new Person();
        person.setId(1);
        person.setName("zs");
        person.setAge(14);
        switch (type){
            case "insert":
                boolean flag = personService.insert(person);
                System.out.println(flag);
                break;
            case "updateById":
                flag =personService.updateById(person);
                System.out.println(flag);
                break;
            case "deleteById":
                personService.deleteById(person);
                personService.deleteById(1);
                break;
            case "selectById":
                Person p = personService.selectById("22");
                System.out.println(JSONObject.toJSONString(p));
                break;
            default:
                break;
        }
        System.out.println(JSONObject.toJSONString(person));
        System.err.println("doTest");
        return "doTest";
    }
}
