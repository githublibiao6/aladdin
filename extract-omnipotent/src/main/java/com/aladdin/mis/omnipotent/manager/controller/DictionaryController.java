package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.manager.bean.Dictionary;
import com.aladdin.mis.service.impl.DictionaryServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController extends GlobalController/*<Dictionary, DictionaryServiceImpl>*/{

    @Autowired
    private DictionaryServiceImpl dicService;

    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Dictionary model) {
        result = new Result();
        Integer id = dicService.insert(model);
        result.setSuccess(id != null);
        if(result.isSuccess()){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Dictionary model) {
        result = new Result();
        boolean flag = dicService.updateSelective(model);
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
        Dictionary m = JSONObject.parseObject(json.toJSONString(),Dictionary.class);
        boolean flag = dicService.remove(json.getInteger("id"));
        result.setSuccess(flag);
        if(flag){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        return result;
    }

    /**
     *  查询字典树
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<JSONObject> records = Db.use().findList("select t.*, t.name label  from be_dictionary t ");
        Map<String , Object> root = new HashMap<>(3);
        root.put("id",0);
        root.put("label","数据字典");
        root.put("children", records);
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(root);
        result.setData(data);
        System.err.println(result.toString());
        result.setCode(20000);
        return result;
    }
}
