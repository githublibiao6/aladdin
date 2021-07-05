package com.apps.omnipotent.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.RoleMenu;
import com.apps.omnipotent.manager.service.impl.RoleServiceImpl;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单controller
* @Description 
* @MethodName  MenuController
* @author lb
* @date 2018年8月20日 下午11:10:32
*
 */
@RequestMapping("roles")
@Controller
public class RoleController extends GlobalController {

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
     * 获取分页
     */
    @RequestMapping("/list")
    @ResponseBody
    public  Result list() {
        List<Role> list = service.list();
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/page")
    @ResponseBody
    public  Result pageList(PageEntity entity) {
        PageEntity page = service.page(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/listMenusByRoleId")
    @ResponseBody
    public  Result listMenusByRoleId(@RequestParam(value = "role_id", defaultValue = "") String roleId) {
        result = new Result();
        List<RoleMenu> list = service.findByRoleId(roleId);
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody JSONObject json) {
        result = new Result();
        Role m = JSONObject.parseObject(json.toJSONString(),Role.class);
        boolean flag = service.add(m, json.getString("menus"));
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        result.setData(m);
        result.setSuccess(flag);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody JSONObject json) {
        result = new Result();
        Role m = JSONObject.parseObject(json.toJSONString(),Role.class);
        boolean flag = service.update(m, json.getString("menus"));
        String msg = "更新成功" ;
        if(!flag){
            msg = "更新失败";
        }
        result.setSuccess(flag);
        result.setMessage(msg);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteOne(@RequestParam(value = "id", defaultValue = "") String id) {
        boolean flag = service.remove(id);
        String msg = "";
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