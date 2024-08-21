package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.service.BeApplicationService;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 应用表 BeApplicationService---
 * @author cles
 * @date 2024-08-21 03:18:00
*/
@RequestMapping("/beApplication")
@Controller
public class BeApplicationController  extends GlobalController<BeApplication, BeApplicationService> {


    /**
     * 获取分页
     */
    @RequestMapping("/pageInfo")
    @ResponseBody
    public  Result pageList(@RequestBody BeApplicationQo qo) {
        PageInfo<BeApplicationVo> page = baseService.page(qo);
        return Result.success(page);
    }

    /**
     * 添加字典
     */
    @Override
    @RequestMapping("/saveInfo")
    @ResponseBody
    public Result saveInfo(@RequestBody BeApplication entity) {
        result = new Result();
        boolean flag = baseService.add(entity);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @Override
    @RequestMapping("/updateInfo")
    @ResponseBody
    public Result updateInfo(@RequestBody BeApplication entity) {
        result = new Result();
        boolean flag = baseService.update(entity);
        result.setSuccess(flag);
        String msg = "更新成功" ;
        if(!flag){
            msg = "更新失败";
        }
        result.setMessage(msg);
        result.setSuccess(flag);
        return result;
    }

    @RequestMapping(value = "/removeInfo",method = RequestMethod.DELETE)
    @ResponseBody
    public Result removeInfo(@RequestBody JSONObject json) {
        boolean flag = baseService.remove(json.getInteger("id"));
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "删除成功";
            return Result.successMsg(msg);
        }else {
            msg = "删除失败";
            return Result.error(msg);
        }
    }
}
