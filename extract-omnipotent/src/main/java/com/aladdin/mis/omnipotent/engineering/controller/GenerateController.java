package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.aladdin.utils.GenerateUtils;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.qo.GenerateQo;
import com.aladdin.mis.engineering.service.GenerateService;
import com.aladdin.mis.engineering.vo.GenerateVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 工程项目 ProjectService---
 * @author cles
 * @date 2021-08-26T23:02:39.368
*/
@RequestMapping("generate")
@Controller
public class GenerateController  {

    @Autowired
    private GenerateService generateService;

    /**
     * 查询数据库所有的表
     */
    @PostMapping("paginate")
    @ResponseBody
    public Result paginate(@RequestBody GenerateQo qo){
        Result result = new Result();
        List<GenerateVo> tables = generateService.paginate(qo);
        result.setData(tables);
        return result ;
    }

    /**
     * 生成表结构类
     */
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@RequestBody JSONObject obj) {
        Result result = new Result();
        try{
            GenerateUtils.create(obj.getString("tableName"), obj.getString("module"));
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
