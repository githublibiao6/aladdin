package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.chat.manager.bean.AdminRole;
import com.aladdin.mis.chat.service.AdminRoleService;
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

    /**
     * 获取分页
     */
    @RequestMapping("/getRoleByAdmin")
    @ResponseBody
    public Result getRoleByAdmin(@RequestBody AdminRole adminRole) {
        List<AdminRole> list = baseService.getRoleByAdmin(adminRole.getAdminId());
        result.setData(list);
        result.setCode(20000);
        return result;
    }

}
