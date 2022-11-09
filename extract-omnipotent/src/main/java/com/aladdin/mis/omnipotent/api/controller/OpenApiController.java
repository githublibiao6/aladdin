package com.aladdin.mis.omnipotent.api.controller;

import com.aladdin.mis.common.aladdin.utils.GenerateUtils;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.omnipotent.api.entity.vo.CreateTableVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对外接口
 * @author lib
 */
@Controller
@RequestMapping("/api")
public class OpenApiController {

    /**
     * 健康地址
     */
    @RequestMapping("/healthy")
    @ResponseBody
    public Result healthy() {
        return Result.success();
    }

    /**
     * 生成表结构
     * @param vo
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@RequestBody CreateTableVo vo) {
        Result result = new Result();
        try{
            GenerateUtils.create(vo.getTableName(), vo.getModule());
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("生成失败");
            result.setSuccess(false);
            return result;
        }
        result.setSuccess(true);
        return result;
    }
}
