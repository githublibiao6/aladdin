package com.aladdin.mis.base.db.factory.impl;

import com.aladdin.mis.base.db.factory.DbTableFactory;
import com.aladdin.mis.base.db.factory.BaseSqlMaker;
import com.aladdin.mis.base.db.factory.DbFactory;

/**
 * @description: sql语句生成工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public class OracleFactory implements DbFactory {

    @Override
    public BaseSqlMaker getSqlMaker() {
        return new OracleSqlMaker();
    }

    @Override
    public DbTableFactory getDbTableFactory() {
        return new OracleTableInfo();
    }
}
