package com.company.manage.dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.manage.dept.bean.Dept;
import com.company.system.common.bean.QueryCondition;

/**
 * 部门 dao
 * @author lb
 *
 */
public interface DeptDao {

    /**
     * 获取所有的部门信息
     * @param queryCondition
     * @return
     */
    List<Dept> listDept(@Param("queryCondition")QueryCondition queryCondition);

    /**
     * 根据id获取部门详细信息
     * @param id
     * @return
     */
    Dept getDeptById(@Param("id")String id);
}
