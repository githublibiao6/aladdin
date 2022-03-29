package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.base.qo.QueryCondition;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import com.aladdin.mis.manager.qo.UserQo;
import com.aladdin.mis.manager.service.UserBaseInfoService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * user controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("user")
@Controller
public class UserBaseInfoController extends GlobalController/*<User, UserServiceImpl>*/ {

    @Autowired
    private UserBaseInfoService service;


    /**
     * 获取分页
     */
    @RequestMapping("/page")
    @ResponseBody
    public  Result pageList(@RequestBody UserQo entity) {
        // 待测试公用查询
        QueryCondition condition = new QueryCondition();
        condition.setPage(1);
        condition.setLimit(10);
        PageInfo<UserBaseInfo> page = service.pageInfo(condition);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 添加字典
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody UserBaseInfo user) {
        result = new Result();
        boolean flag = service.add(user);
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
    public Result update(@RequestBody UserBaseInfo user) {
        result = new Result();
        boolean flag = service.update(user);
        result.setSuccess(flag);
        String msg = "更新成功" ;
        if(!flag){
            msg = "更新失败";
        }
        result.setMessage(msg);
        result.setSuccess(flag);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestBody JSONObject json) {
        User m = JSONObject.parseObject(json.toJSONString(),User.class);
        boolean flag = service.remove(json.getInteger("pk"));
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "删除成功";
        }else {
            msg = "删除失败";
        }
        result.setMessage(msg);
        return result;
    }

}
