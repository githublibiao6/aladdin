package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.service.BeLoginLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.system.qo.BeLoginLogQo;
import com.aladdin.mis.system.vo.BeLoginLogVo;
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
 *  BeLoginLogService--- 
 * @author cles
 * @date 2022-02-24T22:09:10.289
*/
@RequestMapping("system/beLoginLog")
@Controller
public class BeLoginLogController  extends GlobalController {
    @Autowired
    private BeLoginLogService beLoginLogService;

    /**
     * 分页查询
     */
    @PostMapping("paginate")
    @WebLog("分页查询 ")
    @ResponseBody
    public Result paginate(@RequestBody BeLoginLogQo qo){
        PageInfo<BeLoginLogVo> page = beLoginLogService.paginate(qo);
        result.setData(page);
        return result ;
    }

    /**
     * 查询详情
     */
    @PostMapping("detail")
    @WebLog("查询 详情")
    @ResponseBody
    public Result detail(@RequestBody BeLoginLog qo){
        BeLoginLog entity = beLoginLogService.detail(qo);
        result.setData(entity);
        return result ;
    }

    /**
     * 保存
     */
    @PostMapping("save")
    @WebLog("保存")
    @ResponseBody
    public Result save(@RequestBody BeLoginLog entity){
        BeLoginLog data = beLoginLogService.save(entity);
        result.setData(data);
        return result ;
    }

    /**
     * 删除
     */
    @PostMapping("delete")
    @WebLog("删除")
    @ResponseBody
    public Result delete(@RequestBody BeLoginLog entity){
        boolean flag = beLoginLogService.remove(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }

    /**
     * 更新
     */
    @PostMapping("update")
    @WebLog("更新")
    @ResponseBody
    public Result update(@RequestBody BeLoginLog entity){
        boolean flag = beLoginLogService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

}
