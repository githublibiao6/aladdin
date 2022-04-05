package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目计划 ProjectPlanService---
 * @author cles
 * @date 2021-08-31T22:26:17.072
*/
@RequestMapping("projectPlan")
@Controller
public class ProjectPlanController  extends GlobalController<ProjectPlan, ProjectPlanService> {

    @Autowired
    private ProjectPlanService projectPlanService;

    @Override
    protected GlobalService<ProjectPlan> getBaseService() {
        return projectPlanService;
    }
//
//    /**
//     * 分页查询项目计划
//     */
//    @PostMapping("paginate")
//    @WebLog("分页查询 项目计划")
//    @ResponseBody
//    public Result paginate(@RequestBody ProjectPlanQo qo){
//        PageInfo<ProjectPlanVo> page = projectPlanService.paginate(qo);
//        result.setData(page);
//        return result ;
//    }    /**
//     * 查询项目计划详情
//     */
//    @PostMapping("detail")
//    @WebLog("查询 项目计划详情")
//    @ResponseBody
//    public Result detail(@RequestBody ProjectPlan qo){
//        ProjectPlan entity = projectPlanService.detail(qo);
//        result.setData(entity);
//        return result ;
//    }    /**
//     * 保存项目计划
//     */
//    @PostMapping("save")
//    @WebLog("项目计划保存")
//    @ResponseBody
//    public Result save(@RequestBody ProjectPlan entity){
//        ProjectPlan data = projectPlanService.save(entity);
//        result.setData(data);
//        return result ;
//    }    /**
//     * 删除项目计划
//     */
//    @PostMapping("delete")
//    @WebLog("删除项目计划")
//    @ResponseBody
//    public Result delete(@RequestBody ProjectPlan entity){
//        boolean flag = projectPlanService.remove(entity);
//        if(flag){
//            result.setData(entity);
//            result.setMessage("刪除成功");
//        }else {
//            result.setMessage("刪除失败");
//        }
//        return result ;
//    }    /**
//     * 更新项目计划
//     */
//    @PostMapping("update")
//    @WebLog("项目计划更新")
//    @ResponseBody
//    public Result update(@RequestBody ProjectPlan entity){
//        boolean flag = projectPlanService.update(entity);
//        if(flag){
//            result.setData(entity);
//            result.setMessage("更新成功");
//        }else {
//            result.setMessage("更新失败");
//        }
//        return result ;
//    }
}
