package com.aladdin.common.db.factory;

import com.aladdin.common.db.core.DbTableInfo;
import com.aladdin.common.db.factory.impl.MysqlFactory;
import com.aladdin.common.db.factory.impl.OracleFactory;

/**
 * 数据库制造器
 *
 * @author cles
 * @date 2026/04/30
 */
public class DbMaker {

    private static final String MYSQL = "mysql";
    private static final String ORACLE = "oracle";

    public static BaseSqlMaker getDbSqlMaker(String dbType) {
        return getDbFactory(dbType).getSqlMaker();
    }

    public static DbTableInfo getDbTableInfo(String dbType) {
        return getDbFactory(dbType).getTableInfo();
    }

    private static DbFactory getDbFactory(String dbType) {
        DbFactory factory;
        if (MYSQL.equals(dbType)) {
            factory = new MysqlFactory();
        } else {
            factory = new OracleFactory();
        }
        return factory;
    }
}
