package com.aladdin.mis.util;
/**
 * Created by cles on 2020/5/31 12:12
 */


import com.aladdin.mis.annotation.entity.Database;
import com.aladdin.mis.annotation.entity.Table;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */
@Slf4j
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
            Class parent = clazz.getSuperclass();
            boolean parentAnnExits = parent.isAnnotationPresent(Table.class);
            if(parentAnnExits){
                Table table = (Table) parent.getAnnotation(Table.class);
                tableName = table.value();
            }else {
                log.error(clazz +" has not bind table");
            }
            return tableName;
        }
        return tableName;
    }

    /**
     * 功能描述：
     *  < 根据实体类的注解获取表模块 >
     * @Description: getTableName
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public static String getModuleName(Class clazz){
        String databaseName = "";
        boolean tableAnnExits = clazz.isAnnotationPresent(Database.class);
        if(tableAnnExits){
            Database database = (Database) clazz.getAnnotation(Database.class);
            databaseName = database.value();
        }else {
            return null;
        }
        return databaseName;
    }

    /**
     * @Description: 获取主键
     * @Param: [tableName]
     * @return: java.util.List<java.lang.String>
     * @Author: cles
     * @Date: 2020/6/16 23:31
     */
    public  static  String getPrimaryKey(String tableName){
//        TableInfo table = MainDb.getTableInfo(tableName);
//        List<String> pks = table.getPks();
//        if(pks == null || pks.size() == 0){
//            throw new RuntimeException(tableName+" has no primary key");
//        }else {
//            return pks.get(0);
//        }
        return "id";

    }

}
