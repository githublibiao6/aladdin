package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import com.ieslab.misp.excel.util.ExcelUtil;

/**
 * 员工 实体类
 * @author lb
 *
 */
@RequestMapping("employee")
@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeService service;
    
    @RequestMapping("main")
    public String test(){
        
        return "employee/index";
    }
//
//    /**
//     * 导出基础信息（实例）
//     * @param queryCondition
//     * @param response
//     */
//    @RequestMapping(value="/exportexcel.do")
//    public void  export(QueryCondition queryCondition,HttpServletResponse response){
//        List<Employee>  companies=service.getAll(queryCondition);
//        String structure = new StringBuilder("name:员工基本信息;tbody:[id, name, contractStart, contractEnd];").append(
//                "thead:[ 员工ID, 员工名称,合同开始，合同结束]").toString();
//        Workbook workbook = ExcelUtil.createSpreadSheets(companies, structure);
//        String fileName="员工基本信息.xls";
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            workbook.write(os);
//            byte[] bytes = os.toByteArray();
//            response.reset();
//            response.setContentType("application/msexcel;charset=utf-8");
//            response.setHeader("Content-disposition", "attachment;filename= "+ new String(fileName.getBytes("utf-8"), "iso-8859-1"));
//            response.getOutputStream().write(bytes);
//            response.getOutputStream().flush();
//            response.getOutputStream().close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
