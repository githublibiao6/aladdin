package com.company.system.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//        map.put("/**", "anon");
        map.put("/test/user.do", "anon");
        map.put("/system/login.do", "anon");
        map.put("/accessDenied.jsp", "anon");
        map.put("/login.jsp", "anon");
        map.put("/static/**", "anon");
        map.put("/system/menu.do", "anon");
        map.put("/system/user.do", "anon");
        map.put("/system/logout.do", "logout");
        map.put("/system/admin.do", "roles[admin]");
        map.put("/menu/**", "authc");
        map.put("/admin/**", "authc");
        map.put("/test/user.do", "anon");
        map.put("/** ", "authc");
        return map;
    }
}
