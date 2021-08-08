package com.aladdin.mis.dao.db.factory.impl;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.aladdin.mis.dao.core.DbTableInfo;
import com.aladdin.mis.dao.core.impl.MysqlTableInfo;
import com.aladdin.mis.dao.db.factory.BaseSqlMaker;
import com.aladdin.mis.dao.db.factory.DbFactory;

/**
 * @description: sql语句生成工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public class MysqlFactory implements DbFactory {

    @Override
    public BaseSqlMaker getSqlMaker() {
        return new MysqlSqlMaker();
    }

    @Override
    public DbTableInfo getTableInfo() {
        return new MysqlTableInfo();
    }
}
