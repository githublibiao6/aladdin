package com.aladdin.common.db.factory;

import com.aladdin.common.db.core.DbTableInfo;

/**
 * 数据库工厂接口
 *
 * @author cles
 * @date 2026/04/30
 */
public interface DbFactory {

    BaseSqlMaker getSqlMaker();

    DbTableInfo getTableInfo();
}
