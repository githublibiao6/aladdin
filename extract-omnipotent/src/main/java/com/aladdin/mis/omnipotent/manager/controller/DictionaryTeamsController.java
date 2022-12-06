package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.Dictionary;
import com.aladdin.mis.manager.bean.DictionaryTeams;
import com.aladdin.mis.manager.qo.DictionaryQo;
import com.aladdin.mis.manager.service.impl.DictionaryServiceImpl;
import com.aladdin.mis.manager.service.impl.DictionaryTeamsServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "dictionaryteams")
public class DictionaryTeamsController extends GlobalController<DictionaryTeams, DictionaryTeamsServiceImpl> {

    @Autowired
    DictionaryServiceImpl dicService;

    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody DictionaryTeams teams) {
        result = new Result();
        boolean flag = baseService.insert(teams) != null;
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
    public Result update(@RequestBody DictionaryTeams model) {
        result = new Result();
        boolean flag = baseService.updateSelective(model);
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
     * @param model 参数1
     * @return: com.apps.omnipotent.system.global.entity.Result
     * @version: 1.0.0
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody DictionaryTeams model) {
        result = new Result();
        boolean flag = baseService.deleteById(model.getId());
        result.setSuccess(flag);
        if(flag){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        return result;
    }

    @PostMapping("/page")
    @ResponseBody
    public Result page(@RequestBody  DictionaryQo qo) {
        result = new Result();
        result.setCode(20000);
        PageInfo<DictionaryTeams> page = baseService.page(qo);
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
