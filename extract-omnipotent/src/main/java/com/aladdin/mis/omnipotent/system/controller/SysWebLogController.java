package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.entity.SysWebLog;
import com.aladdin.mis.common.db.qo.SysWebLogQo;
import com.aladdin.mis.system.service.SysWebLogService;
import com.aladdin.mis.common.db.vo.SysWebLogVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 请求日志 SysWebLogService---
 * @author cles
 * @date 2021-09-01T00:35:30.813
*/
@RequestMapping("system/sysWebLog")
@Controller
public class SysWebLogController  extends GlobalController<SysWebLog, SysWebLogService> {

    @Autowired
    private SysWebLogService sysWebLogService;

    /**
     * 分页查询请求日志
     */
    @PostMapping("paginate")
    @WebLog("分页查询 请求日志")
    @ResponseBody
    public Result paginate(@RequestBody SysWebLogQo qo){
        PageInfo<SysWebLogVo> page = sysWebLogService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 查询请求日志详情
     */
    @PostMapping("detail")
    @WebLog("查询 请求日志详情")
    @ResponseBody
    public Result detail(@RequestBody SysWebLog qo){
        SysWebLog entity = sysWebLogService.detail(qo);
        result.setData(entity);
        return result ;
    }    /**
     * 保存请求日志
     */
    @PostMapping("save")
    @WebLog("请求日志保存")
    @ResponseBody
    public Result save(@RequestBody SysWebLog entity){
        SysWebLog data = sysWebLogService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除请求日志
     */
    @PostMapping("delete")
    @WebLog("删除请求日志")
    @ResponseBody
    public Result delete(@RequestBody SysWebLog entity){
        boolean flag = sysWebLogService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新请求日志
     */
    @PostMapping("update")
    @WebLog("请求日志更新")
    @ResponseBody
    public Result update(@RequestBody SysWebLog entity){
        boolean flag = sysWebLogService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

}
