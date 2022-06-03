package com.aladdin.mis.manager.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.Digester;
import com.aladdin.mis.common.currency.DefaultTools;
import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.AdminDao;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.qo.AdminQo;
import com.aladdin.mis.manager.service.AdminRoleService;
import com.aladdin.mis.manager.service.AdminService;
import com.aladdin.mis.manager.service.DeptService;
import com.aladdin.mis.manager.vo.DeptAdminVo;
import com.aladdin.mis.manager.vo.DeptVo;
import com.aladdin.mis.pagehelper.entity.QueryCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * admin service
 * @author lb
 * @date 2018年6月5日 下午8:55:47
 */
@Service
public class AdminServiceImpl extends GlobalServiceImpl<Admin> implements AdminService {

    @Autowired
    private AdminDao dao;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private DeptService deptService;
    /**
     * 根据用户名和密码获得 admin
     * @param admin
     * @return
     */
    public boolean verification(Admin admin) {
        admin.setLoginPassword("");
        Admin a =  dao.verification(admin);
        if(a != null){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 根据用户名获得 admin
     * @param username
     * @return
     */
    public Admin getByname(String username, String pass) {
        return dao.getByName(username,pass);
    }

    @Override
    public List<Admin> list() {
        return dao.list();
    }

    @Override
    public PageInfo<Admin> pageList(AdminQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<Admin>  list = dao.pageList(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean add(Admin admin) {
        boolean flag = false;
        String roles = admin.getRoles();
        admin.setLoginPassword(UUID.randomUUID().toString());
        int num = insert(admin);
        if(num > 0){
            flag = true;
            adminRoleService.setRoles(admin.getId(), roles);
        }
        return flag;
    }

    @Override
    public Admin findById(int id){
        return dao.findById(id);
    }

    @Override
    public List<Admin> findByAccount(String account) {
        return dao.findByAccount(account);
    }

    @Override
    public boolean remove(Integer id){
        return deleteById(id);
    }

    @Override
    public boolean update(Admin admin){
        adminRoleService.setRoles(admin.getId(), admin.getRoles());
        return updateSelective(admin);
    }

    /**
     * 获得全部的 admin （导出）
     * @param queryCondition
     * @return
     */
    public List<Admin> getAll(QueryCondition queryCondition) {
        return dao.listAdmin(queryCondition);
    }


    @Override
    public boolean updatePass(Admin user) {

        String salt = RandomUtil.randomString(6);
        user.setSalt(salt);
        user.setSys006("00");
        // MD5 加密
        Digester md5 = DefaultTools.Md5Tool;
        // 密码加密 md5 加密后的密文加上salt 再进行一次 md5加密 生成数据库保存的密码
        String pass = md5.digestHex(user.getLoginPassword() + salt);
        user.setLoginPassword(pass);
        return update(user);
    }

    @Override
    public List<DeptAdminVo> treeDeptAdmin(AdminQo qo) {
        List<Admin> adminList = list();
        List<DeptVo> deptList = deptService.list();
        List<DeptAdminVo> data = convertDeptTree(deptList, -1, adminList);
        return data;
    }


    private List<DeptAdminVo> convertDeptTree(List<DeptVo> list, Integer pid, List<Admin> adminList){
        List<DeptAdminVo> data = new ArrayList<>();
        list.forEach(t->{
            List<DeptVo> children = new ArrayList<>();

            if(pid.equals(t.getParent())){
                DeptAdminVo deptAdminVo = new DeptAdminVo();
                for (Dept record : list) {
                    if(record.getParent().equals(t.getId())){
                        DeptVo vo = (DeptVo) record;
                        vo.setParentName(t.getName());
                        children.add(vo);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertDeptTree(list, t.getId(), adminList);
                    });
                    t.setChildren(children);
                    t.setHasChildren(true);
                }else {
                    t.setHasChildren(false);
                }

                data.add(deptAdminVo);
            }
        });
        return data;
    }
}
