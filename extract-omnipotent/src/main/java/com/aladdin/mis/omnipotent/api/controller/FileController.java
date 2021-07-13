package com.aladdin.mis.omnipotent.api.controller;

import com.aladdin.mis.omnipotent.system.global.controller.GlobalController;
import com.aladdin.mis.omnipotent.system.global.entity.Result;
import com.aladdin.mis.omnipotent.system.utils.FileUtil;
import com.aladdin.mis.omnipotent.system.utils.JedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * 对外接口
 * @author lib
 */
@RestController
@RequestMapping("/file")
public class FileController extends GlobalController {

    @RequestMapping("/downLoadHtml")
    @ResponseBody
    public Result say() {
        String contextPath = request.getContextPath();
        String filePath = "D://demo/pom.xml";
        File file = new File(filePath);
        System.err.println(contextPath);
        System.err.println(file.getAbsolutePath());
        if(!file.exists()){
            result.setSuccess(false);
            result.setMessage("文件不存在");
            return result;
        }
        result.setMessage("文件存在");
        result.setSuccess(true);
        result.setData(JedisUtil.use(0).getList("list"));
        FileUtil.downLoadFile(response,file);
        return result;
    }
}
