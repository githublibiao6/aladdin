package com.aladdin.mis.identity.controller;

import com.aladdin.mis.common.currency.GlobalConfig;
import com.aladdin.mis.common.currency.Parameter;
import com.aladdin.mis.common.redis.config.JedisConfig;
import com.aladdin.mis.common.redis.config.JedisUtil;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.identity.entity.Admin;
import com.aladdin.mis.manager.dto.UserDto;
import com.aladdin.mis.identity.qo.AdminQo;
import com.aladdin.mis.identity.service.AdminService;
import com.aladdin.mis.identity.vo.DeptAdminVo;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * admin controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("admin")
@Controller
public class AdminController extends GlobalController<Admin, AdminService> {

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
        return "/WEB-INF/login.jsp";
    }

    /**
     * 获取分页菜单
     */
    @PostMapping("/page")
    @ResponseBody
    public Result pageList(@RequestBody AdminQo qo) {
        PageInfo<Admin> page = baseService.pageList(qo);
        result.setData(page);
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
        List<Admin> list = baseService.list();
        baseService.insertSelective(new Admin());
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
    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<Admin> list = baseService.list();
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

    @RequestMapping("/save")
    @ResponseBody
    public Result add(@RequestBody Admin admin) {
        boolean flag = baseService.add(admin);
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

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Admin admin) {
        result = new Result();
        boolean flag = baseService.update(admin);
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
    public Result findById(int id) {
        Admin admin = baseService.findById(id);
        result.setData(admin);
        return result;
    }

    @PostMapping(value="/remove")
    @ResponseBody
    public Result remove(@RequestBody Admin admin) {
        boolean flag = baseService.remove(admin.getId());
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

    /**
     * 更新密码
     */
    @RequestMapping("/updatePass")
    @ResponseBody
    public Result updatePass(@RequestBody UserDto dto, HttpSession session) {
        String sessionId = dto.getSessionId();
        // 将验证码放入redis缓存， 等待验证
        // 开启redis时，才进行下面的校验
        if(JedisConfig.getEnableRedis() && GlobalConfig.verifyEnable && GlobalConfig.verifyCode) {
            String verifyCode = JedisUtil.getString(Parameter.RESET_PASS_CODE_PREFIX + ":" + sessionId);
            String code = dto.getVerifyCode();
            if (code == null) {
                return Result.error(50022, "验证码为空");
            }

            if (verifyCode == null) {
                return Result.error(50021, "验证码超时");
            }

            if (!code.equals(verifyCode)) {
                return Result.error(50023, "验证码输入错误");
            }
        }
        Admin admin = new Admin();
        s.copyProperties(dto, admin);

        boolean flag = baseService.updatePass(admin);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 获取组织机构管理员结构
     */
    @RequestMapping("/treeAdmin")
    @ResponseBody
    public Result treeAdmin(@RequestBody AdminQo qo) {

        List<DeptAdminVo> list = baseService
                .treeDeptAdmin(qo);
        return Result.success(list);
    }

}
