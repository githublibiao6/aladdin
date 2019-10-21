package com.company.system.system.junit4;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.manage.employee.controller.EmployeeController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:springContext.xml"})
public class TestExport {
    @Autowired
    private EmployeeController con;
    
    @Test
    public void test() throws ParseException{
//        con.export(null, null);
        
}
}
