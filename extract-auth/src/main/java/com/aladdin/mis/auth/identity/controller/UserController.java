package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.manager.qo.UserQo;
import com.aladdin.mis.manager.service.BeUserMenuService;
import com.aladdin.mis.manager.service.RoleService;
import com.aladdin.mis.manager.service.UserService;
import com.aladdin.mis.manager.service.impl.UserServiceImpl;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * user controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("user")
@Controller
public class UserController extends GlobalController<User, UserServiceImpl> {

    @Autowired
    private UserService service;

    @Autowired
    private BeUserMenuService userMenuService;

    @Autowired
    private RoleService roleService;

    @Override
    protected GlobalService<User> getBaseService() {
        return service;
    }

    /**
     * 注册新用户
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User entity) {

        result = service.register(entity);
        if(entity.getPrimaryKey() == null){
            User data = service.insertSelective(entity);
            result.setData(data);
        }else {
            boolean data = service.updateSelective(entity);
            result.setData(data);
        }
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/page")
    @ResponseBody
    public  Result pageList(@RequestBody UserQo entity) {
        PageInfo<User> page = service.page(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取用户权限
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Result info(String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction","I am a super administrator");
        map.put("name","super Admin");
        map.put("id","001");
        // 就能拿出用户的所有信息，包括角色和权限
        Subject subject = SecurityUtils.getSubject();
        // 获取当前登录用户
        OmUser omUser = (OmUser) subject.getPrincipal();
        Integer userId = omUser.getUserId();
        // 获取用户角色
        Set<String> roles = roleService.getRolesByUserId(userId);
        // 获取用户权限
        List<BeUserMenuVo> permissions = userMenuService.queryMenuByUserId(userId);
        map.put("roles",roles);
        map.put("permissions",permissions);
        result.setCode(20000);
        result.setData(map);
        result.setMessage("用户查询信息");
        return result;
    }

    @RequestMapping("/resetToken")
    @ResponseBody
    public Result resetToken(String token) {
        result.setCode(20000);
        result.setSuccess(true);
        result.setMessage("用户重置");
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/list")
    @ResponseBody
    public  Result list(@RequestParam(value = "name",defaultValue = "") String name) {
        List<User> list = service.list(name);
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody User user) {
        result = new Result();
        boolean flag = service.add(user);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user) {
        result = new Result();
        boolean flag = service.update(user);
        result.setSuccess(flag);
        String msg = "更新成功" ;
        if(!flag){
            msg = "更新失败";
        }
        result.setMessage(msg);
        result.setSuccess(flag);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestBody JSONObject json) {
        User m = JSONObject.parseObject(json.toJSONString(),User.class);
        boolean flag = service.remove(json.getInteger("pk"));
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
