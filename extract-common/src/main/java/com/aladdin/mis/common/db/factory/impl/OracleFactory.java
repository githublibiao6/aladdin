package com.aladdin.mis.common.db.factory.impl;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.aladdin.mis.common.db.core.DbTableInfo;
import com.aladdin.mis.common.db.core.impl.OracleTableInfo;
import com.aladdin.mis.common.db.factory.BaseSqlMaker;
import com.aladdin.mis.common.db.factory.DbFactory;

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
    public DbTableInfo getTableInfo() {
        return new OracleTableInfo();
    }
}
