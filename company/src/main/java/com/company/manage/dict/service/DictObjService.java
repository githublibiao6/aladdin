package com.company.manage.dict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.manage.dict.dao.DictObjDao;


/**
 * 字典对象 Service
 * @author lb
 *
 */
@Service
public class DictObjService {
    
    @Autowired
    private DictObjDao dao;
}
