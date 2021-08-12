package com.aladdin.mis.omnipotent.api.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对外接口
 * @author lib
 */
@Controller
@RequestMapping("/api")
public class OpenApiController extends GlobalController {
    @Autowired
    MenuServiceImpl service;

    @RequestMapping("/index")
    @ResponseBody
    public Result say() {
        result.setSuccess(true);
//        result.setData(JedisUtil.use(0).getList("list"));
        return result;
    }
}
