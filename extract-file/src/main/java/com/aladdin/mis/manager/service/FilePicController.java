package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.entity.Result;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: 系统
* @Author: cles
* @Date: 2020/4/16 22:17
*/
@Slf4j
@Controller
@RequestMapping("/currencyPicture")
public class FilePicController {

    /**
     * 普通上传图片文件
     * @param request
     * @param json
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Result login(HttpServletRequest request, @RequestBody JSONObject json) {
        Result result = new Result();
        //todo 处理上传excel
        return result;
    }

}
