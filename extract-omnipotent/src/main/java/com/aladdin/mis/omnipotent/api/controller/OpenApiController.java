package com.aladdin.mis.omnipotent.api.controller;

import com.aladdin.mis.common.aladdin.utils.GenerateUtils;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.service.impl.MenuServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        return result;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Result create(@RequestBody JSONObject obj) {
        try{
            GenerateUtils.create(obj.getString("tableName"), obj.getString("module"));
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("生成失败");
            result.setSuccess(false);
            return result;
        }
        result.setSuccess(true);
        return result;
    }
}
