package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.service.ProjectRoleService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectRoleQo;
import com.aladdin.mis.engineering.vo.ProjectRoleVo;
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
 * 项目角色 ProjectRoleService--- 
 * @author cles
 * @date 2021-08-29T23:32:45.168
*/
@RequestMapping("projectRole")
@Controller
public class ProjectRoleController  extends GlobalController {
    @Autowired
    private ProjectRoleService projectRoleService;

    /**
     * 分页查询项目角色
     */
    @PostMapping("paginate")
    @WebLog("分页查询 项目角色")
    public Result paginate(@RequestBody ProjectRoleQo qo){
        PageInfo<ProjectRoleVo> page = projectRoleService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存项目角色
     */
    @PostMapping("save")
    @WebLog("项目角色保存")
    public Result save(@RequestBody ProjectRole entity){
        ProjectRole data = projectRoleService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除项目角色
     */
    @PostMapping("delete")
    @WebLog("删除项目角色")
    public Result delete(@RequestBody ProjectRole entity){
        boolean flag = projectRoleService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新项目角色
     */
    @PostMapping("update")
    @WebLog("项目角色更新")
    public Result update(@RequestBody ProjectRole entity){
        boolean flag = projectRoleService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }}
