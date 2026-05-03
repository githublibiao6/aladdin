package com.aladdin.mis.system.service;

import com.aladdin.mis.manager.bean.Project;
import com.aladdin.mis.pagehelper.entity.QueryCondition;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 项目 service
 * @author lb
 * @date 2018年6月24日 下午7:01:35
 */
public interface Project1Service {

    /**
     * 获得全部的project（分页查询）
     * @param draw
     * @param start
     * @param length
     * @param queryCondition
     * @return
     */
    Map<String,Object> listProject(Integer draw, Integer start,Integer length, QueryCondition queryCondition);

    /**
     *  根据id获取project
     * @param id
     * @return
     */
    Project getProject(String id) ;
}
