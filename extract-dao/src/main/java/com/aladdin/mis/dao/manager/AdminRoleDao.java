package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.AdminRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * adminRole dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
@Mapper
public interface AdminRoleDao {

    List<AdminRole> getRoleByAdmin(Integer adminId);

    void removeByAdmin(Integer adminId);
}
