package com.aladdin.mis.dao.db.factory;
/**
 * Created by cles on 2020/5/31 20:54
 */

import com.aladdin.mis.dao.core.DbTableInfo;

/**
 * @description: 数据库工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
public interface DbFactory {

    /**
     * 获取sql创建方法
     * @return
     */
    BaseSqlMaker getSqlMaker();

    /**
     * 获取sql创建方法
     * @return
     */
    DbTableInfo getTableInfo();



}
