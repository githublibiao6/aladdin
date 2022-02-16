package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.manager.service.DeptService;
import com.aladdin.mis.manager.service.impl.DeptServiceImpl;
import com.aladdin.mis.manager.vo.DeptVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门 controller
 * @author lb
 *
 */
@RequestMapping("dept")
@Controller
public class DeptController extends GlobalController {

    @Autowired
    DeptServiceImpl service;

    @Autowired
    private DeptService deptService;

    /**
     *  查询字典树
     */
    @PostMapping("/list")
    @ResponseBody
    public Result list() {
        List<DeptVo> records = deptService.treeList();
        Map<String , Object> root = new HashMap<>(3);
        root.put("id",0);
        root.put("label","组织机构");
        root.put("children", records);
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(root);
        result.setData(data);
        System.err.println(result.toString());
        result.setCode(20000);
        return result;
    }

    /**
     * 分页查询组织机构
     */
    @PostMapping("paginate")
    @WebLog("分页查询 组织机构")
    @ResponseBody
    public Result paginate(@RequestBody DeptQo qo){
        PageInfo<DeptVo> page = deptService.paginate(qo);
        result.setData(page);
        return result ;
    }    /**
     * 保存组织机构
     */
    @PostMapping("save")
    @WebLog("组织机构保存")
    @ResponseBody
    public Result save(@RequestBody Dept entity){
        Dept data = deptService.save(entity);
        result.setData(data);
        return result ;
    }    /**
     * 删除组织机构
     */
    @PostMapping("remove")
    @WebLog("删除组织机构")
    @ResponseBody
    public Result delete(@RequestBody Dept entity){
        boolean flag = deptService.remove(entity.getId());
        if(flag){
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }    /**
     * 更新组织机构
     */
    @PostMapping("update")
    @WebLog("组织机构更新")
    @ResponseBody
    public Result update(@RequestBody Dept entity){
        boolean flag = deptService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

}
