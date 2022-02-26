package com.aladdin.mis.dao.system;

import com.aladdin.mis.system.entity.SqlLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysWebLogService
 * @author cles
 * @date 2021-09-01T00:35:30.806
*/
@Repository
public interface SqlLogDao {
    /**
     * 列表
     * @param m
     * @return list
     */
    List<SqlLog> save(SqlLog m);

}
