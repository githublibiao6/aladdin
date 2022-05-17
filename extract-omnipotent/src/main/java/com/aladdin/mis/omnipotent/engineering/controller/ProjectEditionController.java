package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.qo.QueryCondition;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProjectEditionService projectEditionService;


    @Override
    protected GlobalService<ProjectEdition> getBaseService(){
        return projectEditionService ;
    }

    /**
     * 工程项目版本列表
     */
    @PostMapping("list")
    @WebLog("工程项目版本列表")
    @ResponseBody
    public Result list(@RequestBody ProjectEdition entity){
        QueryCondition condition = QueryCondition.newInstance().addExpression("projectId", entity.getProjectId());
        List<ProjectEdition> list = projectEditionService.queryByCondition(condition);
        result.setData(list);
        return result ;
    }


    /**
     * 更新数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ProjectEdition entity) {
        boolean flag = projectEditionService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }



}
