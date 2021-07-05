package com.apps.omnipotent.system.core;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import java.util.List;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */

public class BaseModelUtil {

    /**
     * 功能描述：
     *  < 根据实体类的注解获取表名 >
     * @Description: getTableName
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public static String getTableName(Class clazz){
        String tableName = "";
        boolean tableAnnExits = clazz.isAnnotationPresent(Table.class);
        if(tableAnnExits){
            Table table = (Table) clazz.getAnnotation(Table.class);
            tableName = table.value();
        }else {
            throw new RuntimeException(clazz +" has not bind table");
        }
        return tableName;
    }

    /**
     * @Description: 获取主键
     * @Param: [tableName]
     * @return: java.util.List<java.lang.String>
     * @Author: cles
     * @Date: 2020/6/16 23:31
     */
    public  static  String getPrimaryKey(String tableName){
        TableInfo table = MainDb.getTableInfo(tableName);
        List<String> pks = table.getPks();
        if(pks == null || pks.size() == 0){
            throw new RuntimeException(tableName+" has no primary key");
        }else {
            return pks.get(0);
        }

    }

}