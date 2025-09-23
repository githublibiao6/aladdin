package com.aladdin.mis.common.controller;

import com.aladdin.mis.common.mapper.system.BeLoginLogDao;
import com.aladdin.mis.common.system.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 测试
 * @author cles
 * @date 2025-09-01 20:50:27
*/
@RequestMapping("/api")
@Controller
public class ApiController  {

    @Autowired
    private BeLoginLogDao beLoginLogDao;

    @RequestMapping("/test")
    @ResponseBody
    public Result test() {
        Result result = new Result();
        result.setSuccess(true);
        beLoginLogDao.list();
        return result;
    }
}
