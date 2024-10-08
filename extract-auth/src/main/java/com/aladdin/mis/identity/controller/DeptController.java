package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.manager.vo.DeptVo;
import com.aladdin.mis.system.service.DeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class DeptController extends GlobalController<Dept, DeptService> {

    /**
     * 获取分页
     */
    @RequestMapping("/listData")
    @ResponseBody
    public  Result listData(@RequestBody DeptQo qo) {
        List<Dept> list = baseService.listData(qo);
        result.setData(list);
        result.setCode(20000);
        return result;
    }

    /**
     *  查询字典树
     */
    @PostMapping("/list")
    @ResponseBody
    public Result list() {
        List<DeptVo> records = baseService.treeList();
        Map<String , Object> root = new HashMap<>(16);
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
        PageInfo<DeptVo> page = baseService.paginate(qo);
        result.setData(page);
        return result ;
    }

    /**
     * 保存组织机构
     */
    @PostMapping("save")
    @WebLog("组织机构保存")
    @ResponseBody
    public Result save(@RequestBody Dept entity){
        Dept data = baseService.save(entity);
        result.setData(data);
        return result ;
    }

    /**
     * 删除组织机构
     */
    @PostMapping("remove")
    @WebLog("删除组织机构")
    @ResponseBody
    public Result delete(@RequestBody Dept entity){
        boolean flag = baseService.remove(entity.getId());
        if(flag){
            result.setMessage("刪除成功");
        }else {
            result.setMessage("刪除失败");
        }
        return result ;
    }

    /**
     * 更新组织机构
     */
    @PostMapping("update")
    @WebLog("组织机构更新")
    @ResponseBody
    public Result update(@RequestBody Dept entity){
        boolean flag = baseService.update(entity);
        if(flag){
            result.setData(entity);
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result ;
    }

    /**
     * 更新组织机构
     */
    @PostMapping("getById")
    @WebLog("根据id获取部门")
    @ResponseBody
    public Result getById(@RequestParam Integer id){
        Dept dept = baseService.getById(id);
        result.setData(dept);
        result.setMessage("查询成功");
        return result ;
    }
}
