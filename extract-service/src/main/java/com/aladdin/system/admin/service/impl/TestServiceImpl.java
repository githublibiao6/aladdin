package com.aladdin.system.admin.service.impl;


import com.aladdin.api.out.interfaces.TestInterface;
import com.aladdin.manage.admin.dao.AdminTestDao;
import com.aladdin.manage.admin.pojo.AdminTest;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TestServiceImpl implements TestInterface {

    @Autowired
    private AdminTestDao dao;

    @Override
    public List<AdminTest> getList() {
        return dao.list();
    }
}
