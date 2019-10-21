package com.company.manage.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.manage.dept.bean.Dept;
import com.company.manage.dept.dao.DeptDao;
import com.company.system.common.bean.QueryCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门service
 * @author lb
 *
 */
@Service
public class DeptService {
    
    @Autowired
    DeptDao dao;
    
    /**
     * 获得全部的部门信息 （分页查询）
     * @param draw
     * @param start
     * @param length
     * @param queryCondition
     * @return
     */
    public Map<String,Object> listDept(Integer draw, Integer start,Integer length, QueryCondition queryCondition) {
        Map<String,Object> result =  new HashMap<String, Object>();
        PageHelper.offsetPage(start, length);
        List<Dept> list = dao.listDept(queryCondition);
        PageInfo<Dept> page = new PageInfo<Dept>(list);
        result.put("data", list);
        result.put("recordsTotal",page.getTotal());//总记录数目
        result.put("recordsFiltered", page.getTotal());// 条件过滤的记录数
        result.put("draw", draw);
        return result;
    }
    
    /**
     * 根据id获取部门详细信息
     * @param id
     * @return
     */
    public Dept getDeptById(String id){
        return dao.getDeptById(id);
        
    }
}
