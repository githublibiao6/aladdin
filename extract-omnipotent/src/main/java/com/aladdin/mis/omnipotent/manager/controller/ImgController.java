package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.Img;
import com.aladdin.mis.bill.service.impl.ImgServiceImpl;
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
public class ImgController extends GlobalController<Img, ImgServiceImpl> {

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
        Img img = baseService.getImgUrl(code, id);
        File file;
        if(img == null){
            img= baseService.createImg(code, id);
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
