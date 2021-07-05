package com.apps.omnipotent.system.db.factory.impl;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.core.impl.MysqlTableInfo;
import com.apps.omnipotent.system.core.impl.OracleTableInfo;
import com.apps.omnipotent.system.db.factory.DbFactory;
import com.apps.omnipotent.system.db.factory.BaseSqlMaker;

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
