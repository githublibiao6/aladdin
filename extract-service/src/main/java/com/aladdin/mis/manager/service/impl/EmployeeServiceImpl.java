package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.EmployeeDao;
import com.aladdin.mis.manager.bean.Employee;
import com.aladdin.mis.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class EmployeeServiceImpl  extends GlobalServiceImpl<Employee> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


}
