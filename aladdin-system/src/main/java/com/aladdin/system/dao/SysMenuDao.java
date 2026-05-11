package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统菜单数据访问：" *
 * @author cles
 * @date 2026/05/06
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenu> {
}
