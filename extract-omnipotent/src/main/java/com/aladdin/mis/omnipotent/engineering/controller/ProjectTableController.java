package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.service.ProjectTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目表 ProjectTableService---
 * @author cles
 * @date 2021-09-14T00:07:18.702
*/
@RequestMapping("engineering/projectTable")
@Controller
public class ProjectTableController  extends GlobalController<ProjectTable, ProjectTableService> {

    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectTable entity) {
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
    public Result update(@RequestBody ProjectTable entity) {
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
    @RequestMapping("/deleteTable")
    @ResponseBody
    public Result deleteTable(@RequestBody ProjectTable entity) {
        boolean flag = baseService.deleteTable(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
