package com.aladdin.mis.omnipotent.business.controller;

import com.aladdin.mis.blog.entity.Essay;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.omnipotent.business.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典 Controller
 * @author lb
 *
 */
@RestController
@RequestMapping(value = "/business/essay")
public class EssayController extends GlobalController<Essay, EssayService> {

    @Autowired
    private EssayService service;

    @Override
    protected GlobalService<Essay> getBaseService() {
        return service;
    }
/*
    @RequestMapping("/page")
    @ResponseBody
    public Result page(HttpServletRequest request, PageEntity entity) {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        Cookie[] cookies = request.getCookies();
        System.err.println("cookies:" + cookies);
        PageInfo<Essay> page = service.page(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }
    *//**
     * 添加文章
     *//*
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Essay m) {
        Result result = new Result();
        result = new Result();
        boolean flag = service.add(m);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Essay m) {
        Result result = new Result();
        result = new Result();
        boolean flag = service.update(m);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("更新成功");
        }else {
            result.setMessage("更新失败");
        }
        return result;
    }

    *//**
     * 功能描述：
     *  < 删除 >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/6/21 23:46
     * @param json 参数1
     * @return: com.apps.omnipotent.system.global.entity.Result
     * @version: 1.0.0
     *//*
    @RequestMapping("/remove")
    @ResponseBody
    public Result remove(@RequestBody JSONObject json) {
        Result result = new Result();
        result = new Result();
        boolean flag = service.remove(json.getInteger("id"));
        result.setSuccess(flag);
        if(flag){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        return result;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Result detail(@RequestParam(value = "id",defaultValue = "") Integer id) {
        Result result = new Result();
        result = new Result();
        Essay essay = service.detail(id);
        result.setData(essay);
        return result;
    }*/
}
