package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.service.ProjectTableService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTableQo;
import com.aladdin.mis.engineering.vo.ProjectTableVo;
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
 * 项目表 ProjectTableService--- 
 * @author cles
 * @date 2021-08-29T23:32:52.590
*/
@RequestMapping("projectTable")
@Controller
public class ProjectTableController  extends GlobalController {
    @Autowired
    private ProjectTableService projectTableService;

    /**
     * 分页查询项目表
     */
    @PostMapping("paginate")
    @WebLog("分页查询 项目表")
    public Result paginate(@RequestBody ProjectTableQo qo){
        PageInfo<ProjectTableVo> page = projectTableService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存项目表
     */
    @PostMapping("save")
    @WebLog("项目表保存")
    public Result save(@RequestBody ProjectTable entity){
        ProjectTable data = projectTableService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除项目表
     */
    @PostMapping("delete")
    @WebLog("删除项目表")
    public Result delete(@RequestBody ProjectTable entity){
        boolean flag = projectTableService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新项目表
     */
    @PostMapping("update")
    @WebLog("项目表更新")
    public Result update(@RequestBody ProjectTable entity){
        boolean flag = projectTableService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }}
