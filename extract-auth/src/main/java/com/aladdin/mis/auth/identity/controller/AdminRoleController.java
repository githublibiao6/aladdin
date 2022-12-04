package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.AdminRole;
import com.aladdin.mis.manager.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * user controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("adminRole")
@Controller
public class AdminRoleController extends GlobalController<AdminRole, AdminRoleService> {

    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * 获取分页
     */
    @RequestMapping("/getRoleByAdmin")
    @ResponseBody
    public Result getRoleByAdmin(@RequestBody AdminRole adminRole) {
        List<AdminRole> list = adminRoleService.getRoleByAdmin(adminRole.getAdminId());
        result.setData(list);
        result.setCode(20000);
        return result;
    }

}
