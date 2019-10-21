package com.company.manage.employee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.manage.employee.bean.Employee;
import com.company.system.common.bean.QueryCondition;

/**
 * 员工 dao
 * @author lb
 *
 */
public interface EmployeeDao {

    /**
     * 获取所有的员工信息
     * @param queryCondition
     * @return
     */
    List<Employee> listEmployee(@Param("queryCondition")QueryCondition queryCondition);

    /**
     * 根据id获取员工详情
     * @param id
     * @return
     */
    Employee getEmployee(@Param("id")String id);
}
