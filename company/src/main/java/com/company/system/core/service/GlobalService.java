package com.company.system.core.service;

import com.company.manage.admin.bean.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class GlobalService {

    public Admin getAdmin(){
        Session session = SecurityUtils.getSubject().getSession();
        return (Admin)session.getAttribute(session.getId()+"type");
    }
    public String getId(){
        Session session = SecurityUtils.getSubject().getSession();
        return (String)session.getAttribute(session.getId()+"id");
    }
    public String getDeptId(){
        Session session = SecurityUtils.getSubject().getSession();
        return (String) session.getAttribute(session.getId()+"dept");
    }
    public String getUserType(){
        Session session = SecurityUtils.getSubject().getSession();
        String o = (String)session.getAttribute(session.getId()+"type");
        return o;
    }
}
