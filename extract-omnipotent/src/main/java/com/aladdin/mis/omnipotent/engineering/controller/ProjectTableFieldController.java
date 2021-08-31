package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTableFieldQo;
import com.aladdin.mis.engineering.vo.ProjectTableFieldVo;
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
 * 项目表字段 ProjectTableFieldService--- 
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@RequestMapping("projectTableField")
@Controller
public class ProjectTableFieldController  extends GlobalController {
    @Autowired
    private ProjectTableFieldService projectTableFieldService;

    /**
     * 分页查询项目表字段
     */
    @PostMapping("paginate")
    @WebLog("分页查询 项目表字段")
    @ResponseBody
    public Result paginate(@RequestBody ProjectTableFieldQo qo){
        PageInfo<ProjectTableFieldVo> page = projectTableFieldService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存项目表字段
     */
    @PostMapping("save")
    @WebLog("项目表字段保存")
    @ResponseBody
    public Result save(@RequestBody ProjectTableField entity){
        ProjectTableField data = projectTableFieldService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除项目表字段
     */
    @PostMapping("delete")
    @WebLog("删除项目表字段")
    @ResponseBody
    public Result delete(@RequestBody ProjectTableField entity){
        boolean flag = projectTableFieldService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新项目表字段
     */
    @PostMapping("update")
    @WebLog("项目表字段更新")
    @ResponseBody
    public Result update(@RequestBody ProjectTableField entity){
        boolean flag = projectTableFieldService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }}
