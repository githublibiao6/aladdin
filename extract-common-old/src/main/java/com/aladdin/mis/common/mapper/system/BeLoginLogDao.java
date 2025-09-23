package com.aladdin.mis.common.mapper.system;

import com.aladdin.mis.common.db.bean.SqlLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BeLoginLogDao
 * @author cles
 * @date 2025-02-24T23:38:47.811
*/
@Mapper
@Repository
public interface BeLoginLogDao {

    /**
     * 测试
     * @return list
     */
    List<SqlLog> list();

}
