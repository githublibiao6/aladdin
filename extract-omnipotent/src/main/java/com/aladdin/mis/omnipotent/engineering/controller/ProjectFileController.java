package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.qo.Condition;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.engineering.service.ProjectFileService;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目版本文件资料 ProjectFileService---
 * @author cles
 * @date 2022-05-25T00:29:11.440
*/
@RequestMapping("engineering/projectFile")
@Controller
public class ProjectFileController  extends GlobalController<ProjectFile, ProjectFileService> {

    /**
     * 获取分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageVoInfo(@RequestBody ProjectFileQo qo) {
        PageInfo<ProjectFileVo> page = baseService.pageByDto(qo);
        return Result.success(page);
    }
    /**
     * 工程项目版本列表
     */
    @PostMapping("list")
    @WebLog("工程项目版本列表")
    @ResponseBody
    public Result list(@RequestBody ProjectFile entity){
        Condition condition = Condition.newInstance().addExpression("relationId", entity.getRelationId());
        List<ProjectFile> list = baseService.queryByCondition(condition);
        result.setData(list);
        return result ;
    }

    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectFile entity) {
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
    public Result update(@RequestBody ProjectFile entity) {
        boolean flag = baseService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除数据
     */
    @RequestMapping("/deleteFile")
    @ResponseBody
    public Result deleteFile(@RequestBody ProjectFile entity) {
        boolean flag = baseService.deleteFile(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 下载数据
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public Result downloadFile(@RequestBody ProjectFile entity) {
        boolean flag = baseService.downloadFile(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 作废文件
     */
    @RequestMapping("/cancellation")
    @ResponseBody
    public Result cancellation(@RequestBody ProjectFile entity) {
        boolean flag = baseService.cancellation(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 恢复文件
     */
    @RequestMapping("/recover")
    @ResponseBody
    public Result recover(@RequestBody ProjectFile entity) {
        boolean flag = baseService.recover(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }


}
