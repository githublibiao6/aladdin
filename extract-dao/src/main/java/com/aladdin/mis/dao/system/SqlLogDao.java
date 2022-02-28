package com.aladdin.mis.dao.system;

import com.aladdin.mis.system.entity.SqlLog;
import org.springframework.stereotype.Repository;

/**
 * SqlLogDao
 * @author cles
 * @date 2021-09-01 00:35:30.806
*/
@Repository
public interface SqlLogDao {
    /**
     * 列表
     * @param m
     * @return list
     */
    int save(SqlLog m);

}
