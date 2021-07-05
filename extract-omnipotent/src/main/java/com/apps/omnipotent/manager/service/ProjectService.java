package com.apps.omnipotent.manager.service;

import com.apps.omnipotent.manager.bean.Project;
import com.apps.omnipotent.manager.dao.ProjectDao;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
