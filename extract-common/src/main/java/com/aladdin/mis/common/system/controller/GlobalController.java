package com.aladdin.mis.common.system.controller;


import com.aladdin.mis.base.qo.QueryCondition;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.system.base.BaseModel;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author cles
 */
public abstract class  GlobalController<T extends BaseModel, M extends GlobalService<T>> {

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    protected abstract GlobalService<T> getBaseService();

    protected Result result = new Result();

//    PageHandle layui = new LayuiPageHandle();

//    public <T> Result page(List<T> list,Integer page,Integer limit){
//        return layui.turnPage(result,list,page,limit);
//    }

    /**
     * 获取通用分页
     */
    @PostMapping("/pageInfo")
    @ResponseBody
    public Result pageInfo(@RequestBody QueryCondition condition) {
        condition.setPage(1);
        condition.setLimit(10);
        condition.setPage(2);
        condition.addExpression("id",1);
        PageInfo<T> page = getBaseService().pageInfo(condition);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取通用list
     */
    @PostMapping("/listInfo")
    @ResponseBody
    public Result listInfo(@RequestBody QueryCondition condition) {
        condition.setPage(1);
        condition.setLimit(10);
        List<T> page = getBaseService().listInfo(condition);
        result.setData(page);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取通用保存
     */
    @RequestMapping("/saveInfo")
    @ResponseBody
    public Result saveInfo(@RequestBody T entity) {
        if(entity.getPrimaryKey() == null){
            T data = getBaseService().insertSelective(entity);
            result.setData(data);
        }else {
            boolean data = getBaseService().updateSelective(entity);
            result.setData(data);
        }
        result.setCode(20000);
        return result;
    }

    /**
     * 获取通用保存
     */
    @PutMapping("/")
    @ResponseBody
    public Result saveOrUpdate(@RequestBody T entity) {
        if(entity.getPrimaryKey() == null){
            T data = getBaseService().insertSelective(entity);
            result.setData(data);
        }else {
            boolean data = getBaseService().updateSelective(entity);
            result.setData(data);
        }
        result.setCode(20000);
        return result;
    }

    /**
     * 获取分页
     */
    @RequestMapping("/updateInfo")
    @ResponseBody
    public Result updateInfo(@RequestBody T entity) {
        boolean data = getBaseService().updateSelective(entity);
        result.setData(data);
        result.setCode(20000);
        return result;
    }

     /**
     * 根据主键删除数据
     */
    @RequestMapping("/deleteInfo")
    @ResponseBody
    public Result deleteInfo(@RequestBody T entity) {
        boolean data = getBaseService().deleteById(entity.getPrimaryKey());
        result.setData(data);
        result.setCode(20000);
        return result;
    }

    /**
     * 根据主键删除数据
     * [restful]
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteInfo(@PathVariable("id") Integer id) {
        boolean data = getBaseService().deleteById(id);
        result.setData(data);
        result.setCode(20000);
        return result;
    }

    /**
     * 根据主键删除数据
     */
    @RequestMapping("/detailInfo")
    @ResponseBody
    public Result detailInfo(@RequestBody T entity) {
        T data = getBaseService().detailQuery(entity.getPrimaryKey());
        result.setData(data);
        result.setCode(20000);
        return result;
    }

    /**
     * 根据主键删除数据
     * [restful]
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result detailInfo(@PathVariable("id") Integer id) {
        T data = getBaseService().detailQuery(id);
        result.setData(data);
        result.setCode(20000);
        return result;
    }

    /**
     * 根据主键删除数据
     */
    @RequestMapping("/getByCondition")
    @ResponseBody
    public Result detailQuery(@RequestBody QueryCondition condition) {
        T data = getBaseService().getByCondition(condition);
        result.setData(data);
        result.setCode(20000);
        return result;
    }

    /**
     * 获取前台传入的参数
     * @param key
     * @return
     */
    public String getPara(String key){
        return request.getParameter(key);
    }

    public <T> T getModel(JSONObject json,Class<T> mode) throws IllegalAccessException, InstantiationException {
        Field[] fields = mode.getFields();
        T t = mode.newInstance();
        for(Field s:fields){
            s.setAccessible(true);
            s.set(t,json.get(s.getName()));
        }
        return t;
    }

    public String getProjectUrl(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://"+address.getHostAddress() +":"+request.getServerPort()+"/"+request.getContextPath();
    }

    /**
     * 获取当前用户
     * @return
     */
    public OmUser getCurrentUser(){
        return (OmUser) SecurityUtils.getSubject().getPrincipal();
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     * 获取ip
     * @return ip
     */
    public  String getIp() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
