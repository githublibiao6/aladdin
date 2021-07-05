package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.bean.Img;
import com.apps.omnipotent.manager.service.impl.ImgServiceImpl;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 业务项目 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("img")
@Controller
public class ImgController extends GlobalController {

    @Autowired
    ImgServiceImpl service;
    /**
     * 功能描述：
     *  < 返回图片 >
     * @Description: getImage
     * @Author: cles
     * @Date: 2020/7/13 22:05
     * @return: byte[]
     * @version: 1.0.0
     */
    @RequestMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@RequestParam(value = "code",defaultValue = "")String code,
                           @RequestParam(value = "id",defaultValue = "")String id) throws IOException {
        Img img = service.getImgUrl(code, id);
        File file;
        if(img == null){
            img= service.createImg(code, id);
        }
        try{
            file = new File(img.getUrl());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }


    /**
     * 功能描述：
     *  < 返回图片地址 >
     * @Description: getImageUrl
     * @Author: cles
     * @Date: 2020/7/13 22:05
     * @return: com.apps.omnipotent.system.global.entity.Result
     * @version: 1.0.0
     */
    @RequestMapping(value = "/getImg/{id}")
    @ResponseBody
    public Result getImageUrl(@PathVariable(value = "id")String id){
        result = new Result();
        String url = getProjectUrl()+"/img/get?code=01&id="+id;
        result.setData(url);
        return result;
    }

}
