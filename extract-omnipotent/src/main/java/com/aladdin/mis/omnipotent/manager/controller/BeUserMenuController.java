package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.manager.entity.BeUserMenu;
import com.aladdin.mis.manager.service.BeUserMenuService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.manager.qo.BeUserMenuQo;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
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
 *  BeUserMenuService--- 
 * @author cles
 * @date 2022-03-01T22:38:09.377
*/
@RequestMapping("manager/beUserMenu")
@Controller
public class BeUserMenuController  extends GlobalController {
    @Autowired
    private BeUserMenuService beUserMenuService;

    /**
     * 分页查询
     */
    @PostMapping("paginate")
    @WebLog("分页查询 ")
    @ResponseBody
    public Result paginate(@RequestBody BeUserMenuQo qo){
        PageInfo<BeUserMenuVo> page = beUserMenuService.paginate(qo);
        result.setData(page);
        return result ;
    }

    /**
     * 查询详情
     */
    @PostMapping("detail")
    @WebLog("查询 详情")
    @ResponseBody
    public Result detail(@RequestBody BeUserMenu qo){
        BeUserMenu entity = beUserMenuService.detail(qo);
        result.setData(entity);
        return result ;
    }

    /**
     * 保存
     */
    @PostMapping("save")
    @WebLog("保存")
    @ResponseBody
    public Result save(@RequestBody BeUserMenu entity){
        BeUserMenu data = beUserMenuService.save(entity);
        result.setData(data);
        return result ;
    }

    /**
     * 删除
     */
    @PostMapping("delete")
    @WebLog("删除")
    @ResponseBody
    public Result delete(@RequestBody BeUserMenu entity){
        boolean flag = beUserMenuService.remove(entity);
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
    public Result update(@RequestBody BeUserMenu entity){
        boolean flag = beUserMenuService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

}
