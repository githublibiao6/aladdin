package com.company.manage.dict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.manage.dict.dao.DictDao;


/**
 * 字典 Service
 * @author lb
 *
 */
@Service
public class DictService {
    
    @Autowired
    private DictDao dao;
}
