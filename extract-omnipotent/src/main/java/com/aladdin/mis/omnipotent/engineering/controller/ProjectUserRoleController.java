package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.service.ProjectUserRoleService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectUserRoleQo;
import com.aladdin.mis.engineering.vo.ProjectUserRoleVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 *  ProjectUserRoleService--- 
 * @author cles
 * @date 2021-08-31T22:03:55.931
*/
@RequestMapping("projectUserRole")
@Controller
public class ProjectUserRoleController  extends GlobalController {
    @Autowired
    private ProjectUserRoleService projectUserRoleService;

    /**
     * 分页查询
     */
    @PostMapping("paginate")
    @WebLog("分页查询 ")
    @ResponseBody
    public Result paginate(@RequestBody ProjectUserRoleQo qo){
        PageInfo<ProjectUserRoleVo> page = projectUserRoleService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存
     */
    @PostMapping("save")
    @WebLog("保存")
    @ResponseBody
    public Result save(@RequestBody ProjectUserRole entity){
        ProjectUserRole data = projectUserRoleService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除
     */
    @PostMapping("delete")
    @WebLog("删除")
    @ResponseBody
    public Result delete(@RequestBody ProjectUserRole entity){
        boolean flag = projectUserRoleService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新
     */
    @PostMapping("update")
    @WebLog("更新")
    @ResponseBody
    public Result update(@RequestBody ProjectUserRole entity){
        boolean flag = projectUserRoleService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }}
