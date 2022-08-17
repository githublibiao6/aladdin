package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.engineering.service.ProjectService;
import com.aladdin.mis.engineering.vo.ProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 工程项目 ProjectService---
 * @author cles
 * @date 2021-08-26T23:02:39.368
*/
@RequestMapping("project")
@Controller
public class ProjectController  extends GlobalController<Project, ProjectService> {

    @Autowired
    private ProjectService projectService;

    @Override
    protected GlobalService<Project> getBaseService() {
        return projectService;
    }

    /**
     * 分页查询工程项目
     */
    @PostMapping("paginate")
    @WebLog("分页查询工程项目")
    @ResponseBody
    public Result paginate(@RequestBody ProjectQo qo){
        PageInfo<ProjectVo> page = projectService.paginate(qo);
        result.setData(page);
        return result ;
    }

    /**
     * 保存工程项目
     */
    @PostMapping("save")
    @WebLog("工程项目保存")
    @ResponseBody
    public Result save(@RequestBody Project entity){
        Project data = projectService.save(entity);
        result.setData(data);
        return result ;
    }

    /**
     * 删除工程项目
     */
    @PostMapping("delete")
    @WebLog("删除工程项目")
    @ResponseBody
    public Result delete(@RequestBody Project entity){
        boolean flag = projectService.deleteProject(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }

    /**
     * 更新工程项目
     */
    @PostMapping("update")
    @WebLog("工程项目更新")
    @ResponseBody
    public Result update(@RequestBody Project entity){
        boolean flag = projectService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

    /**
     * 删除工程
     */
    @PostMapping("deleteById")
    @WebLog("工程项目更新")
    @ResponseBody
    public Result deleteById(@RequestBody Project entity){
        boolean flag = projectService.deleteProject(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

    /**
     * 开始工程
     */
    @PostMapping("startProject")
    @WebLog("工程项目开始")
    @ResponseBody
    public Result startProject(@RequestBody Project entity){
        boolean flag = projectService.startProject(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }


    /**
     * 挂起工程
     */
    @PostMapping("hang")
    @WebLog("工程项目更新")
    @ResponseBody
    public Result hang(@RequestBody Project entity){
        boolean flag = projectService.hang(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

    /**
     * 继续工程
     */
    @PostMapping("continue")
    @WebLog("工程项目更新")
    @ResponseBody
    public Result continueProject(@RequestBody Project entity){
        boolean flag = projectService.continueProject(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }


    /**
     * 完成工程
     */
    @RequestMapping("complete")
    @ResponseBody
    public Result complete(@RequestBody Project entity) {
        boolean flag = projectService.complete(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}
