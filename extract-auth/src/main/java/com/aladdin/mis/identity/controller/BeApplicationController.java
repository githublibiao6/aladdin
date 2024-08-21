package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.service.BeApplicationService;
import com.aladdin.mis.manager.bean.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 应用表 BeApplicationService---
 * @author cles
 * @date 2024-08-21 03:18:00
*/
@RequestMapping("/beApplication")
@Controller
public class BeApplicationController  extends GlobalController<BeApplication, BeApplicationService> {

    /**
     * 获取详细信息
     */
    @PostMapping("getById")
    @WebLog("根据id获取应用")
    @ResponseBody
    public Result getById(@RequestParam Integer id){
        Dept dept = baseService.detailQuery(id);
        result.setData(dept);
        result.setMessage("查询成功");
        return result ;
    }
}
