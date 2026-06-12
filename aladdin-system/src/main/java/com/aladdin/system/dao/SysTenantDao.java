package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysTenant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 租户DAO
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysTenantDao extends BaseDao<SysTenant> {

    @Select("SELECT * FROM sys_tenant WHERE tenant_code = #{tenantCode} AND sys005 = 1")
    SysTenant selectByTenantCode(@Param("tenantCode") String tenantCode);
}
