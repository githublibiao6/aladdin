package com.company.manage.admin.controller;

import com.company.manage.admin.bean.Admin;
import com.company.manage.admin.service.impl.AdminServiceImpl;
import com.company.system.common.bean.QueryCondition;
import com.company.system.core.controller.GlobalController;
import com.company.system.core.model.Result;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ieslab.misp.excel.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * admin controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("admin")
@Controller
public class AdminController extends GlobalController {
    
    @Autowired
    AdminServiceImpl service;

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "system/admin/index";
    }
    /**
     * 
     * @return
     */
    @RequestMapping("main")
    public String test(){
        return "admin/index";
    }
    
    @RequestMapping("login")
    public String login(Mode m, Admin admin, HttpSession httpSession){
        //**********************shiro验证******************************//
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(admin.getLoginName(), admin.getLoginPassword());
            //remember me
            token.setRememberMe(true);
            try {
                //传到了 com.jsp.manage.shiro.realm.doGetAuthenticationInfo
                System.out.println("开始shiro");
                currentUser.login(token);
            } catch (AuthenticationException e) {
                System.out.println("******************************登陆失败********************错误信息：");
                System.out.println(e.getMessage());
                System.out.println("*********************错误信息结束********************************");
            }
        }
        return "/WEB-INF/login.jsp";
    }

    /**
     * 获取分页菜单
     */
    @RequestMapping("/pagelist.do")
    @ResponseBody
    public Result paageList(Integer page, Integer limit) {
        List<Admin>  list = service.pagelist();
        result.setData(list);
        result=page(list,page,limit);
        return result;
    }


    /**
     * 获取菜单
     *
     * @return List<Role>
     * @Description
     * @MethodName index
     * @author lb
     * @date 2018年8月21日 下午9:56:33
     */
    @RequestMapping("/treelist.do")
    @ResponseBody
    public List<Admin> treeList() {
        List<Admin> list = service.list();
        return list;
    }

    /**
     * 获取菜单
     *
     * @return List<Role>
     * @Description
     * @MethodName index
     * @author lb
     * @date 2018年8月21日 下午9:56:33
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public Result list() {
        List<Admin> list = service.list();
        result.setData(list);
        return result;
    }

    /**
     * 菜单跳转新增编辑页面
     *
     * @return
     */
    @RequestMapping("/addoreditrender.do")
    public String addOrEditRender() {
        return "system/admin/addoredit";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result add(Admin admin) {
        boolean flag = service.add(admin);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "添加成功";
        }else {
            msg = "添加失败";
        }
        result.setMessage(msg);
        return result;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public Result update(Admin admin) {
        boolean flag = service.update(admin);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "更新成功";
        }else {
            msg = "更新失败";
        }
        result.setMessage(msg);
        return result;
    }


    @RequestMapping("/findById.do")
    @ResponseBody
    public Result findById(String id) {
        Admin admin = service.findById(id);
        result.setData(admin);
        return result;
    }
    @RequestMapping("/remove.do")
    @ResponseBody
    public Result remove(String id) {
        boolean flag = service.remove(id);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "删除成功";
        }else {
            msg = "删除失败";
        }
        result.setMessage(msg);
        return result;
    }
//  
    /**
     * 导出基础信息（实例）
     * @param queryCondition
     * @param response
     */
    @RequestMapping(value="/exportexcel.do")
    public void  export(QueryCondition queryCondition,HttpServletResponse response){
        List<Admin>  companies=service.getAll(queryCondition);
        String structure = new StringBuilder("name:员工基本信息;tbody:[id, loginName, notes];").append(
                "thead:[ 管理员ID, 登录名,说明]").toString();
        Workbook workbook = ExcelUtil.createSpreadSheets(companies, structure);
        String fileName="员工基本信息.xls";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);
            byte[] bytes = os.toByteArray();
            response.reset();
            response.setContentType("application/msexcel;charset=utf-8");
            response.setHeader("Content-disposition", "attachment;filename= "+ new String(fileName.getBytes("utf-8"), "iso-8859-1"));
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
