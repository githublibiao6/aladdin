package com.company.manage.role.controller;

import com.company.manage.role.mode.Role;
import com.company.manage.role.service.impl.RoleServiceImpl;
import com.company.system.core.controller.GlobalController;
import com.company.system.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单controller
* @Description 
* @MethodName  MenuController
* @author lb
* @date 2018年8月20日 下午11:10:32
*
 */
@RequestMapping("role")
@Controller
public class RoleController extends GlobalController{

    @Autowired
    RoleServiceImpl service;

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "system/role/index";
    }


    /**
     * 菜单跳转新增编辑页面
     *
     * @return
     */
    @RequestMapping("/addoreditrender.do")
    public String addOrEditRender() {
        return "system/role/addoredit";
    }

    /**
     * 获取分页菜单
     */
    @RequestMapping("/pagelist.do")
    @ResponseBody
    public  Result paageList(Integer page, Integer limit) {
        List<Role>  list = service.pagelist();
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
    public List<Role> treeList() {
        List<Role> list = service.list();
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
        List<Role> list = service.list();
        result.setData(list);
        return result;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result add(Role role) {
        boolean flag = service.add(role);
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
    public Result update(Role role) {
        boolean flag = service.update(role);
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
        Role role = service.findById(id);
        result.setData(role);
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
}