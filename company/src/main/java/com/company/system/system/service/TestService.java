package com.company.system.system.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.system.system.dao.TestDao;

@Service
public class TestService {

    @Autowired
    TestDao dao;
    
    //shiro注解，需要有admin才能访问
    @RequiresRoles({"admin"})
    public String shiro() {
        return null;
    }
}
