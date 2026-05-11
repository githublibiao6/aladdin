package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色数据访问：" *
 * @author cles
 * @date 2026/05/06
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRole> {
}
