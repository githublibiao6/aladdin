package com.apps.omnipotent.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.bean.DictionaryTeams;
import com.apps.omnipotent.manager.service.DictionaryTeamsService;
import com.apps.omnipotent.manager.service.impl.DictionaryServiceImpl;
import com.apps.omnipotent.manager.service.impl.DictionaryTeamsServiceImpl;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "dictionaryteams")
public class DictionaryTeamsController extends GlobalController {

    @Autowired
    DictionaryServiceImpl dicService;

    @Autowired
    DictionaryTeamsServiceImpl teamsService;


    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody JSONObject json) {
        result = new Result();
        DictionaryTeams m = JSONObject.parseObject(json.toJSONString(),DictionaryTeams.class);
        boolean flag = teamsService.add(m);
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
        DictionaryTeams m = JSONObject.parseObject(json.toJSONString(),DictionaryTeams.class);
        boolean flag = teamsService.update(m);
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
     * @Description: delete
     * @Author: cles
     * @Date: 2020/6/21 23:46
     * @param json 参数1
     * @return: com.apps.omnipotent.system.global.entity.Result
     * @version: 1.0.0
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody JSONObject json) {
        result = new Result();
        DictionaryTeams m = JSONObject.parseObject(json.toJSONString(),DictionaryTeams.class);
        boolean flag = teamsService.remove(json.getString("id"));
        result.setSuccess(flag);
        if(flag){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Result page(PageEntity entity, @RequestParam(value = "dic_id", defaultValue = "0") String dicId) {
        result = new Result();
        result.setCode(20000);
        PageEntity page = teamsService.page(dicId,entity);
        result.setData(page);
        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<Dictionary> list = dicService.list();
        result.setData(list);
        result.setCode(20000);
        return result;
    }
}
