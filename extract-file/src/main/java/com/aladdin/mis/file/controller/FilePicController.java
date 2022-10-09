package com.aladdin.mis.file.controller;

import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.file.service.FilePictureService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FilePictureService filePictureService;

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

    /**
     * 普通上传base64文件
     * @param request
     * @param json
     * @return
     */
    @RequestMapping("/uploadBase64")
    @ResponseBody
    public Result uploadBase64(HttpServletRequest request, @RequestBody JSONObject json) {
        String base64 = json.getString("base64");
        Result result = new Result();
        // 处理上传图片
        String url = filePictureService.uploadBase64(request, base64);
        result.setData(url);
        return result;
    }

}
