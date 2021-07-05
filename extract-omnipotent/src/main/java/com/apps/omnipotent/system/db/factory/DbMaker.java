package com.apps.omnipotent.system.db.factory;
/**
 * Created by cles on 2020/5/31 21:52
 */

import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.db.factory.impl.MysqlFactory;
import com.apps.omnipotent.system.db.factory.impl.OracleFactory;

/**
 * @description: 数据库的制造机
 * @author cles
 * @Date 2020/5/31 21:52
 */
public class DbMaker {

    private static final String MYSQL = "mysql";
    private static final String ORACLE = "oracle";

    public static BaseSqlMaker getDbSqlMaker(String dbType){
        return getDbFactory(dbType).getSqlMaker();
    }

    public static DbTableInfo getDbTableInfo(String dbType){
        return getDbFactory(dbType).getTableInfo();
    }

    private static DbFactory getDbFactory(String dbType){
        DbFactory factory;
        if(MYSQL.equals(dbType)){
            factory = new MysqlFactory();
        }else {
            factory = new OracleFactory();
        }
        return factory;
    }
}
