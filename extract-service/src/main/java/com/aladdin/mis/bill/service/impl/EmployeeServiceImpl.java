package com.aladdin.mis.bill.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.EmployeeDao;
import com.aladdin.mis.manager.bean.Employee;
import com.aladdin.mis.bill.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
public class EmployeeServiceImpl  extends GlobalServiceImpl<Employee> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


}
