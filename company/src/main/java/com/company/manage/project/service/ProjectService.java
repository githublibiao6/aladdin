package com.company.manage.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.manage.project.bean.Project;
import com.company.manage.project.dao.ProjectDao;
import com.company.system.common.bean.QueryCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 项目 service
 * @author lb
 * @date 2018年6月24日 下午7:01:35
 */
@Service
public class ProjectService {

    @Autowired
    ProjectDao dao;
    
    /**
     * 获得全部的project（分页查询）
     * @param draw
     * @param start
     * @param length
     * @param queryCondition
     * @return
     */
    public Map<String,Object> listProject(Integer draw, Integer start,Integer length, QueryCondition queryCondition) {
        Map<String,Object> result =  new HashMap<String, Object>();
        PageHelper.offsetPage(start, length);
        List<Project> list = dao.listProject(queryCondition);
        PageInfo<Project> page = new PageInfo<Project>(list);
        result.put("data", list);
        result.put("recordsTotal",page.getTotal());//总记录数目
        result.put("recordsFiltered", page.getTotal());// 条件过滤的记录数
        result.put("draw", draw);
        return result;
    }
    
    /**
     *  根据id获取project
     * @param id
     * @return
     */
    public Project getProject(String id) {
        return dao.getProject(id);
    }
}
