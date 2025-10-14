package com.aladdin.mis.base.db.factory;

import org.springframework.stereotype.Service;

/**
 * @description: 数据库工厂
 * @author cles
 * @Date 2020/5/31 20:54
 */
@Service
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
    DbTableFactory getDbTableFactory();

}
