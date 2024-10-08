package com.aladdin.mis.system.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.qo.AdminQo;
import com.aladdin.mis.manager.vo.DeptAdminVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description: 管理员service接口
* @Author: cles
* @Date: 2020/4/28 23:13
*/
public interface AdminService  extends GlobalService<Admin> {

    /**
     * 列表
     * @return
     */
    List<Admin> list();

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo<Admin> pageList(AdminQo qo);

    /**
     * 新增
     * @param menu
     * @return
     */
    boolean add(Admin menu);

    /**
     * 更新
     * @param menu
     * @return
     */
    boolean update(Admin menu);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean remove(Integer id);

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    Admin findById(int id);

    /**
     * 根据账号获取用户查询详情
     * @param account
     * @return
     */
    List<Admin> findByAccount(String account);

    /**
     * 更新密码
     * @param user
     * @return
     */
    boolean updatePass(Admin user);

    /**
     *
     * @param qo
     * @return
     */
    List<DeptAdminVo> treeDeptAdmin(AdminQo qo);
}
