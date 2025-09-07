package com.aladdin.mis.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("demo")
@RestController
public class DemoController {

    /**
     * 健康地址
     * @return obj
     */
    @RequestMapping("/welcome")
    @ResponseBody
    public JSONObject welcome() {
        JSONObject obj = new JSONObject();
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
