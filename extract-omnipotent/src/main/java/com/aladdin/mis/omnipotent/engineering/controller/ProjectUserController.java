package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.engineering.service.ProjectUserService;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *  ProjectUserService---
 * @author cles
 * @date 2021-10-12T00:48:59.022
*/
@RequestMapping("engineering/projectUser")
@Controller
public class ProjectUserController  extends GlobalController {
    @Autowired
    private ProjectUserService projectUserService;

    /**
     * 分页查询
     */
    @PostMapping("paginate")
    @WebLog("分页查询 ")
    @ResponseBody
    public Result paginate(@RequestBody ProjectUserQo qo){
        PageInfo<ProjectUserVo> page = projectUserService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 查询详情
     */
    @PostMapping("detail")
    @WebLog("查询 详情")
    @ResponseBody
    public Result detail(@RequestBody ProjectUser qo){
        ProjectUser entity = projectUserService.detail(qo);
        result.setData(entity);
        return result ;
    }    /**
     * 保存
     */
    @PostMapping("save")
    @WebLog("保存")
    @ResponseBody
    public Result save(@RequestBody ProjectUser entity){
        ProjectUser data = projectUserService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除
     */
    @PostMapping("delete")
    @WebLog("删除")
    @ResponseBody
    public Result delete(@RequestBody ProjectUser entity){
        boolean flag = projectUserService.remove(entity);
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
    public Result update(@RequestBody ProjectUser entity){
        boolean flag = projectUserService.update(entity);
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
