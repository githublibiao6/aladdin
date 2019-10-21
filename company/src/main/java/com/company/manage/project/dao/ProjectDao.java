package com.company.manage.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.manage.project.bean.Project;
import com.company.system.common.bean.QueryCondition;

/**
 * 项目 dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
public interface ProjectDao {

    /**
     * 根据条件获得Project
     * @param queryCondition
     * @return
     */
    List<Project> listProject(@Param("queryCondition")QueryCondition queryCondition);

    /**
     * 根据id获得Project
     * @param id
     * @return
     */
    Project getProject(@Param("id")String id);
}
