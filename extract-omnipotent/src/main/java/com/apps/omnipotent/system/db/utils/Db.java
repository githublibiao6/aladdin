package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 22:44
 */

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @description: 数据源操作工具
 * @author cles
 * @Date 2020/5/10 22:44
 */
@Slf4j
public class Db {
    private static HashMap<String , DruidDataSource> map = new HashMap<>();
    private static DruidDataSource main = null ;

    /**
    * @Description: 添加数据源
    * @Param: [key, dataSource]
    * @return: void
    * @Author: cles
    * @Date: 2020/5/10 23:11
    */
    public static void setDbSource(String key,DruidDataSource dataSource){
        map.put(key,dataSource);
    }
    public static DruidDataSource getDbSource(String key){
        return map.get(key);
    }
    /**
    * @Description: 设置系统数据源
    * @Param: [key, dataSource]
    * @return: void
    * @Author: cles
    * @Date: 2020/5/10 23:12
    */
    public static void setMain(DruidDataSource dataSource){
        log.info("主数据源加入成功");
        main = dataSource;
    }

    /**
    * @Description: 使用系统数据源
    * @return: com.apps.omnipotent.system.db.utils.DbPro
    * @Author: cles
    * @Date: 2020/5/10 23:12
    */
    public static DbPro use(){
        return new DbPro(main) ;
    }

    /**
    * @Description: 选择数据源
    * @Param: [key]
    * @return: com.apps.omnipotent.system.db.utils.DbPro
    * @Author: cles
    * @Date: 2020/5/10 23:12
    */
    public static DbPro use(String key){
        DruidDataSource dataSource = map.get(key);
        if( dataSource == null){
            throw new IllegalArgumentException("Db-"+key+": Data source not configured");
        }
        return new DbPro(dataSource);
    }

}
