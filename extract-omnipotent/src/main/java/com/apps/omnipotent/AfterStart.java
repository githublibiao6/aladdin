package com.apps.omnipotent;

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.service.impl.MenuServiceImpl;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.service.impl.RoleServiceImpl;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import com.apps.omnipotent.system.db.utils.Db;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
* @Description:  加载后执行
* @Author: cles
* @Date: 2020/4/15 23:29
*/
@Slf4j
@Component
@Order(value = 1)
public class AfterStart implements ApplicationRunner {

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    MenuServiceImpl menuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动后执行");
        /*将菜单缓存进redis*/
        List<Role> list= roleService.list();
        list.forEach(role->{
            String code = role.getCode();
            List<Menu> menuList = menuService.queryByRoleId(code);
//            JedisUtil.setList("role"+code,menuList);
        });
        /* 将主数据源的表缓存 */
        MainDb.init();
        Map<String, TableInfo> map = MainDb.getTableMap();
        List<JSONObject> t = Db.use().findList("select * from be_admin");
        map.forEach((k,v)->{
            System.err.println(k);
        });
    }
}
