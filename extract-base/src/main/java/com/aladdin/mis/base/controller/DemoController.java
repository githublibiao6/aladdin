package com.aladdin.mis.base.controller;

import com.aladdin.mis.base.mapper.BaseMapper;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 * @author lb
 * @date 2025年9月21日 下午5:56:11
 */
@RequestMapping("api")
@RestController
public class DemoController {

    @Resource
    private BaseMapper baseMapper;

    /**
     * 健康地址
     * @return obj
     */
    @RequestMapping("/test")
    @ResponseBody
    public JSONObject welcome() {
        JSONObject obj = new JSONObject();
        baseMapper.find();
        obj.put("success", true);
        obj.put("message", "访问成功");
        obj.put("code", 200);
        obj.put("data", null);
        return obj;
    }

}
