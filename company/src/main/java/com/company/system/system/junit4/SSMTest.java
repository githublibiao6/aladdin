package com.company.system.system.junit4;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.manage.menu.mode.Menu;
import com.company.manage.menu.service.impl.MenuServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:springContext.xml"})
public class SSMTest {
    @Autowired
    private MenuServiceImpl service;
    @Test
    public void test() throws ParseException{
        List<Menu> a = service.list();
        System.err.println(a.get(0));
        System.err.println(a.size());
}
}
