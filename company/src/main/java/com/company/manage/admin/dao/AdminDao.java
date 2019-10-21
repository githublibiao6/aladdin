package com.company.manage.admin.dao;

import com.company.manage.admin.bean.Admin;
import com.company.system.common.bean.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * admin dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
public interface AdminDao {
    /**
     * 查看传入的admin是否存在
     * @param admin
     * @return
     */
    Admin verification(@Param("admin")Admin admin);

    /**
     * 根据登录名获得admin
     * @param name
     * @return
     */
    Admin getByname(@Param("name")String name,@Param("pass")String pass);

    List<Admin> listAdmin(@Param("name")QueryCondition queryCondition);

    List<Admin> list();

    List<Admin> pageList();

    int  add(Admin menu);

    int  update(Admin menu);

    Admin  findById(String  id);

    int  remove(String  id);
}
