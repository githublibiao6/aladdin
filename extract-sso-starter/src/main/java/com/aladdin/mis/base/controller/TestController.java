package com.aladdin.mis.base.controller;

import com.aladdin.mis.base.entity.Person;
import com.aladdin.mis.base.entity.Teacher;
import com.aladdin.mis.base.service.PersonService;
import com.aladdin.mis.base.service.TeacherService;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("test")
@RestController
@Log4j2
public class TestController {

    @Autowired
    private PersonService personService;

    @Autowired
    private TeacherService teacherService;

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
                Teacher teacher = new Teacher();
                teacher.setId(1);
                teacher.setName("zs");
                teacher.setAge(14);
                teacherService.insert(teacher);
                break;
            case "updateById":
                flag =personService.updateById(person);
                break;
            case "deleteById":
                personService.deleteById(person);
                personService.deleteById(1);
                break;
            case "selectById":
                Person p = personService.selectById("22");
                log.error(JSONObject.toJSONString(p));
                break;
            case "selectByIds":
                List<Integer> ids = new ArrayList<>();
                ids.add(1);
                ids.add(2);
                List<Person> people = personService.selectBatchIds(ids);
                log.error(JSONObject.toJSONString(people));
                break;
            default:
                break;
        }
        return "doTest";
    }
}
