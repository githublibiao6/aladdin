package com.aladdin.mis.omnipotent.love.controller;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.love.entity.DateLog;
import com.aladdin.mis.omnipotent.love.service.DateLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/love/record")
public class LoveController extends GlobalController {

    @Autowired
    private DateLogService service;

    @RequestMapping("/page")
    @ResponseBody
    public  Result pageList(PageEntity entity) {
        PageEntity page = service.page(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }
    /**
     * 添加文章
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody JSONObject json) {
        result = new Result();
        DateLog m = JSONObject.parseObject(json.toJSONString(), DateLog.class);
        boolean flag = service.add(m);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody JSONObject json) {
        result = new Result();
        DateLog m = JSONObject.parseObject(json.toJSONString(), DateLog.class);
        boolean flag = service.update(m);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result;
    }

    /**
     * 功能描述：
     *  < 删除 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:46
     * @param json 参数1
     * @return: com.apps.omnipotent.system.global.entity.Result
     * @version: 1.0.0
     */
    @RequestMapping("/remove")
    @ResponseBody
    public Result remove(@RequestBody JSONObject json) {
        result = new Result();
        boolean flag = service.remove(json.getInteger("id"));
        result.setSuccess(flag);
        if(flag){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Result detail(@RequestParam(value = "id",defaultValue = "") Integer id) {
        result = new Result();
        DateLog dateLog = service.detail(id);
        result.setData(dateLog);

        return result;
    }

    @Override
    protected GlobalService getBaseService() {
        return null;
    }
}
