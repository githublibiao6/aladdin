package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目计划参与人员 ProjectPlanUserService---
 * @author cles
 * @date 2021-08-29T23:32:31.977
*/
@RequestMapping("projectPlanUser")
@Controller
public class ProjectPlanUserController  extends GlobalController {

    @Autowired
    private ProjectPlanUserService projectPlanUserService;

    /**
     * 分页查询项目计划参与人员
     */
    @PostMapping("paginate")
    @WebLog("分页查询 项目计划参与人员")
    public Result paginate(@RequestBody ProjectPlanUserQo qo){
        PageInfo<ProjectPlanUserVo> page = projectPlanUserService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存项目计划参与人员
     */
    @PostMapping("save")
    @WebLog("项目计划参与人员保存")
    public Result save(@RequestBody ProjectPlanUser entity){
        ProjectPlanUser data = projectPlanUserService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除项目计划参与人员
     */
    @PostMapping("delete")
    @WebLog("删除项目计划参与人员")
    public Result delete(@RequestBody ProjectPlanUser entity){
        boolean flag = projectPlanUserService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新项目计划参与人员
     */
    @PostMapping("update")
    @WebLog("项目计划参与人员更新")
    public Result update(@RequestBody ProjectPlanUser entity){
        boolean flag = projectPlanUserService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

    @Override
    protected GlobalService getBaseService() {
        return null;
    }
}
