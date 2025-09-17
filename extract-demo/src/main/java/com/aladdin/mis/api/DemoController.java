package com.aladdin.mis.api;

import com.aladdin.mis.mapper.BeLoginLogMapper;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("api")
@RestController
public class DemoController {

    @Resource
    private BeLoginLogMapper beLoginLogMapper;

    /**
     * 健康地址
     * @return obj
     */
    @RequestMapping("/test")
    @ResponseBody
    public JSONObject welcome() {
        JSONObject obj = new JSONObject();
        beLoginLogMapper.list();
        obj.put("success", true);
        obj.put("message", "访问成功");
        obj.put("code", 20000);
        obj.put("data", null);
        return obj;
    }

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "test/index";
    }

}
