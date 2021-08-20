package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * admin dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
@Mapper
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

    Admin  findById(int id);

    int  remove(String id);
}
