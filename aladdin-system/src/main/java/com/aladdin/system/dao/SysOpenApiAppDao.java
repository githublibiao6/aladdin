package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysOpenApiApp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Open-API应用DAO
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysOpenApiAppDao extends BaseDao<SysOpenApiApp> {

    @Select("SELECT * FROM sys_open_api_app WHERE access_key = #{accessKey} AND sys005 = 1")
    SysOpenApiApp selectByAccessKey(@Param("accessKey") String accessKey);
}
