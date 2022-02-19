package com.aladdin.mis.common.system.controller;


import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author cles
 */
public abstract class GlobalController {

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    protected Result result = new Result();

//    PageHandle layui = new LayuiPageHandle();

//    public <T> Result page(List<T> list,Integer page,Integer limit){
//        return layui.turnPage(result,list,page,limit);
//    }

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
