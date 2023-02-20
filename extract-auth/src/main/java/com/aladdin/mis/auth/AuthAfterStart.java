package com.aladdin.mis.auth;

import com.aladdin.mis.common.utils.SpringBeanFactoryUtils;
import com.aladdin.mis.common.db.dao.SqlLogDao;
import com.aladdin.mis.common.db.config.DbPro;
import com.aladdin.mis.manager.bean.Menu;
import com.aladdin.mis.manager.bean.Role;
import com.aladdin.mis.manager.service.MenuService;
import com.aladdin.mis.manager.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description:  加载后执行
* @Author: cles
* @Date: 2020/4/15 23:29
*/
@Slf4j
@Component
@Order(value = 2)
public class AuthAfterStart implements ApplicationRunner {

    private RoleService roleService;

    private MenuService menuService;

    @Autowired
    private SqlLogDao sqlLogDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        setService();

        try{
            // 临时处理sqlDao为空的问题
            DbPro.setSqlLogDao(sqlLogDao);
            log.info("启动后执行");
            /*将菜单缓存进redis*/
            List<Role> list= roleService.list();
            list.forEach(role->{
                String code = role.getCode();
                List<Menu> menuList = menuService.queryByRoleId(code);
//                JedisUtil.setList("role"+code,menuList);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setService(){
        if(roleService == null){
            roleService = SpringBeanFactoryUtils.getBean(RoleService.class);
        }
        if(menuService == null){
            menuService = SpringBeanFactoryUtils.getBean(MenuService.class);
        }

    }
}
