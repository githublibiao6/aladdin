package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.base.qo.Condition;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.qo.ProjectEditionQo;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import com.aladdin.mis.engineering.vo.ProjectEditionVo;
import com.aladdin.mis.base.controller.GlobalController;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目版本记录 ProjectEditionService---
 * @author cles
 * @date 2022-05-11T01:37:39.288
*/
@RequestMapping("engineering/projectEdition")
@Controller
public class ProjectEditionController  extends GlobalController<ProjectEdition, ProjectEditionService> {

    /**
     * 获取分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageVoInfo(@RequestBody ProjectEditionQo qo) {
        PageInfo<ProjectEditionVo> page = baseService.pageByDto(qo);
        return Result.success(page);
    }

    /**
     * 工程项目版本列表
     */
    @PostMapping("list")
    @WebLog("工程项目版本列表")
    @ResponseBody
    public Result list(@RequestBody ProjectEdition entity){
        Condition condition = Condition.newInstance().addExpression("projectId", entity.getProjectId());
        List<ProjectEdition> list = baseService.queryByCondition(condition);
        result.setData(list);
        return result ;
    }

    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectEdition entity) {
        boolean flag = baseService.save(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }


    /**
     * 更新数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ProjectEdition entity) {
        boolean flag = baseService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 作废版本
     */
    @RequestMapping("/cancellation")
    @ResponseBody
    public Result cancellation(@RequestBody ProjectEdition entity) {
        boolean flag = baseService.cancellation(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除版本
     */
    @RequestMapping("/deleteEdition")
    @ResponseBody
    public Result deleteEdition(@RequestBody ProjectEdition entity) {
        boolean flag = baseService.deleteEdition(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 回复版本
     */
    @RequestMapping("/recover")
    @ResponseBody
    public Result recover(@RequestBody ProjectEdition entity) {
        boolean flag = baseService.recover(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}
