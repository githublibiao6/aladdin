package com.aladdin.mis.dao;

import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.dao.system.SqlLogDao;
import com.aladdin.mis.dao.utils.DbPro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
    private SqlLogDao sqlLogDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try{
            // 临时处理sqlDao为空的问题
            DbPro.setSqlLogDao(sqlLogDao);
            log.info("启动后执行");
            /*将菜单缓存进redis*/
            /* 将主数据源的表缓存 */
            MainDb.init();
//            Map<String, TableInfo> map = MainDb.getTableMap();
//            List<JSONObject> t = Db.use().findList("select * from be_admin");
            /*map.forEach((k,v)->{
                System.err.println(k);
            });*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
