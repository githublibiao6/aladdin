package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.qo.AdminQo;
import com.aladdin.mis.pagehelper.entity.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * admin dao
 * @author lb
 * @date 2018年6月5日 下午8:56:31
 */
@Repository
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
     * @param pass
     * @return
     */
    Admin getByName(@Param("name") String name, @Param("pass") String pass);

    /**
     * 获取管理员
     * @param queryCondition
     * @return
     */
    List<Admin> listAdmin(@Param("name") QueryCondition queryCondition);

    /**
     * 获取全部admin
     * @return list
     */
    List<Admin> list();

    /**
     * 分页获取
     * @param qo
     * @return
     */
    List<Admin> pageList(AdminQo qo);

    /**
     * 添加
     * @param menu
     * @return
     */
    int  add(Admin menu);

    /**
     * 更新
     * @param menu
     * @return
     */
    int  update(Admin menu);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    Admin  findById(int id);

    /**
     * 删除
     * @param id
     * @return
     */
    int  remove(String id);

    /**
     * 根据账号获取用户
     * @param account
     * @return
     */
    List<Admin> findByAccount(@Param("account") String account);
}
