package com.aladdin.common.db.dao;

import com.aladdin.common.db.bean.SqlLog;
import org.springframework.stereotype.Repository;

/**
 * SQL日志数据访问
 *
 * @author cles
 * @date 2026/04/30
 */
@Repository
public interface SqlLogDao {

    int save(SqlLog m);
}
