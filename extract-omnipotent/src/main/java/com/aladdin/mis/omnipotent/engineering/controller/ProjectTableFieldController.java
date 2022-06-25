package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目表字段 ProjectTableFieldService---
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@RequestMapping("projectTableField")
@Controller
public class ProjectTableFieldController  extends GlobalController<ProjectTableField,ProjectTableFieldService> {

    @Autowired
    private ProjectTableFieldService projectTableFieldService;

    @Override
    protected GlobalService<ProjectTableField> getBaseService() {
        return projectTableFieldService;
    }


    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectTableField entity) {
        boolean flag = projectTableFieldService.save(entity);
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
    public Result update(@RequestBody ProjectTableField entity) {
        boolean flag = projectTableFieldService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
