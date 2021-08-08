package com.aladdin.mis.omnipotent.manager.dao;

import com.aladdin.mis.manager.bean.Employee;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    List<Employee> listEmployee(@Param("queryCondition") QueryCondition queryCondition);

    /**
     * 根据id获取员工详情
     * @param id
     * @return
     */
    Employee getEmployee(@Param("id") String id);
}
