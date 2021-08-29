package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 * 项目计划 ProjectPlanService--- 
 * @author cles
 * @date 2021-08-29T23:32:16.053
*/
@RequestMapping("projectPlan")
@Controller
public class ProjectPlanController  extends GlobalController {
    @Autowired
    private ProjectPlanService projectPlanService;

    /**
     * 分页查询项目计划
     */
    @PostMapping("paginate")
    @WebLog("分页查询 项目计划")
    public Result paginate(@RequestBody ProjectPlanQo qo){
        PageInfo<ProjectPlanVo> page = projectPlanService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存项目计划
     */
    @PostMapping("save")
    @WebLog("项目计划保存")
    public Result save(@RequestBody ProjectPlan entity){
        ProjectPlan data = projectPlanService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除项目计划
     */
    @PostMapping("delete")
    @WebLog("删除项目计划")
    public Result delete(@RequestBody ProjectPlan entity){
        boolean flag = projectPlanService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新项目计划
     */
    @PostMapping("update")
    @WebLog("项目计划更新")
    public Result update(@RequestBody ProjectPlan entity){
        boolean flag = projectPlanService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }}
