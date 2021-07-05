package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Admin;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * admin dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
@Component
public interface AdminDao {
    /**
     * 功能描述：
     *  < 查看传入的admin是否存在 >
     * @Description: verification
     * @Author: cles
     * @Date: 2020/6/21 23:51
     * @param admin 参数1
     * @return: com.apps.omnipotent.manager.bean.Admin
     * @version: 1.0.0
     */
    Admin verification(@Param("admin") Admin admin);

    /**
     * 根据登录名获得admin
     * @param name
     * @return
     */
    Admin getByName(@Param("name") String name, @Param("pass") String pass);

    List<Admin> listAdmin(@Param("name") QueryCondition queryCondition);

    List<Admin> list();

    List<Admin> pageList();

    int  add(Admin menu);

    int  update(Admin menu);

    Admin  findById(String id);

    int  remove(String id);
}
