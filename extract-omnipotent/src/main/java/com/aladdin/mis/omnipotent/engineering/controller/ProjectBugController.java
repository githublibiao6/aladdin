package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.service.ProjectBugService;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目缺陷管理 ProjectBugService---
 * @author cles
 * @date 2022-06-07T00:17:28.418
*/
@RequestMapping("engineering/projectBug")
@Controller
public class ProjectBugController extends GlobalController<ProjectBug, ProjectBugService> {

    @Autowired
    private ProjectBugService projectBugService;

    /**
     * 获取分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageVoInfo(@RequestBody ProjectBugQo qo) {
        PageInfo<ProjectBugVo> page = projectBugService.pageByDto(qo);
        return Result.success(page);
    }

    /**
     * 获取通用保存
     * 因为阿里规范检查，必须要加注解
     */
    @Override
    @RequestMapping("/saveInfo")
    @ResponseBody
    public Result saveInfo(@RequestBody ProjectBug entity) {
        if(entity.getPrimaryKey() == null){
            ProjectBug data = baseService.insertSelective(entity);
            result.setData(data);
        }else {
            boolean data = baseService.updateSelective(entity);
            result.setData(data);
        }
        return result;
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody ProjectBug entity) {
        boolean flag = baseService.save(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 更新
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ProjectBug entity) {
        boolean flag = baseService.update(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 删除
     */
    @PostMapping("/deleteBug")
    @ResponseBody
    public Result deleteBug(@RequestBody ProjectBug entity) {
        boolean flag = baseService.deleteBug(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 完成缺陷
     */
    @PostMapping("/complete")
    @ResponseBody
    public Result completeBug(@RequestBody ProjectBug entity) {
        boolean flag = baseService.completeBug(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }


}
