package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.manager.bean.Employee;
import org.springframework.stereotype.Service;

/**
 * 员工  service
 * @author lb
 *
 */
@Service
public class EmployeeService  extends GlobalServiceImpl<Employee> {

//    @Autowired
//    EmployeeDao dao;
//
//    /**
//     * 获得全部的 员工信息 （分页查询）
//     * @param draw
//     * @param start
//     * @param length
//     * @param queryCondition
//     * @return
//     */
//    public Map<String,Object> listEmployee(Integer draw, Integer start,Integer length, QueryCondition queryCondition) {
//        Map<String,Object> result =  new HashMap<String, Object>();
////        PageHelper.offsetPage(start, length);
////        List<Employee> list = dao.listEmployee(queryCondition);
////        PageInfo<Employee> page = new PageInfo<Employee>(list);
////        result.put("data", list);
////        result.put("recordsTotal",page.getTotal());//总记录数目
////        result.put("recordsFiltered", page.getTotal());// 条件过滤的记录数
////        result.put("draw", draw);
//        return result;
//    }
//
//    /**
//     * 根据id获取员工详情
//     * @param id
//     * @return
//     */
//    public Employee getEmployee(String id){
//        return dao.getEmployee(id);
//    }
//
//    /**
//     * 导出例子：获取所有的员工
//     * @param queryCondition
//     * @return
//     */
//    public List<Employee> getAll(QueryCondition queryCondition) {
//        return dao.listEmployee(queryCondition);
//    }
}
