package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.Role;
import com.aladdin.mis.manager.bean.RoleMenu;
import com.aladdin.mis.system.service.RoleService;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
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
public class RoleController extends GlobalController<Role, RoleService> {

    /**
     * 添加角色
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Role m) {
        result = new Result();
        boolean flag = baseService.add(m);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        result.setData(m);
        result.setSuccess(flag);
        return result;
    }

    /**
     * 菜单跳转
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
        List<Role> list = baseService.list();
        list.forEach(t->{
            t.setHasChildren(false);
            t.setRoleId(t.getId());
        });
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/page")
    @ResponseBody
    public Result pageList(PageEntity entity) {
        PageInfo<Role> page = baseService.page(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/listMenusByRoleId")
    @ResponseBody
    public Result listMenusByRoleId(@RequestParam(value = "role_id", defaultValue = "") Integer roleId) {
        result = new Result();
        List<RoleMenu> list = baseService.findByRoleId(roleId);
        list.forEach(t->{
            t.setDisabled(true);
        });
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody JSONObject json) {
        result = new Result();
        Role m = JSONObject.parseObject(json.toJSONString(),Role.class);
        boolean flag = baseService.update(m, json.getString("menus"));
        String msg = "更新成功" ;
        if(!flag){
            msg = "更新失败";
        }
        result.setSuccess(flag);
        result.setMessage(msg);
        return result;
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteOne(@RequestParam(value = "id", defaultValue = "") Integer id) {
        boolean flag = baseService.remove(id);
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
