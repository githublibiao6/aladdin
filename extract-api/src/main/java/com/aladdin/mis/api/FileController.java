package com.aladdin.mis.api;

import com.aladdin.common.security.redis.util.RedisUtil;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.common.core.utils.FileUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        result.setData(RedisUtil.getList("list"));
        FileUtil.downLoadFile(response,file);
        return result;
    }
}
