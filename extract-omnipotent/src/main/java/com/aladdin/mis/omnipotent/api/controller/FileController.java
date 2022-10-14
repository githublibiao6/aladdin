package com.aladdin.mis.omnipotent.api.controller;

import com.aladdin.mis.common.redis.config.JedisUtil;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.omnipotent.system.utils.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 对外接口
 * @author lib
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/downLoadHtml")
    @ResponseBody
    public Result say(HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
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
