package com.aladdin.common.db.factory.impl;

import com.aladdin.common.db.core.DbTableInfo;
import com.aladdin.common.db.core.impl.OracleTableInfo;
import com.aladdin.common.db.factory.BaseSqlMaker;
import com.aladdin.common.db.factory.DbFactory;

/**
 * Oracle工厂
 *
 * @author cles
 * @date 2026/04/30
 */
public class OracleFactory implements DbFactory {

    @Override
    public BaseSqlMaker getSqlMaker() {
        return new OracleSqlMaker();
    }

    @Override
    public DbTableInfo getTableInfo() {
        return new OracleTableInfo();
    }
}
