package com.aladdin.common.db.factory.impl;

import com.aladdin.common.db.core.DbTableInfo;
import com.aladdin.common.db.core.impl.MysqlTableInfo;
import com.aladdin.common.db.factory.BaseSqlMaker;
import com.aladdin.common.db.factory.DbFactory;

/**
 * MySQL工厂
 *
 * @author cles
 * @date 2026/04/30
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
