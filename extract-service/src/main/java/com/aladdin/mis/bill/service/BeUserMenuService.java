package com.aladdin.mis.bill.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.entity.BeUserMenu;
import com.aladdin.mis.manager.qo.BeUserMenuQo;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BeUserMenuService
 * @author cles
 * @date 2022-03-01T22:38:09.314
*/
@Service
public interface BeUserMenuService extends GlobalService<BeUserMenu>  {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<BeUserMenuVo> paginate(BeUserMenuQo qo);

    /**
     * 查询详情
     * @param qo
     * @return entity
     */
    BeUserMenu detail(BeUserMenu qo);

    /**
     * 删除
     * @param entity
     * @return flag
     */
    boolean remove(BeUserMenu entity);

    /**
     * 更新
     * @param entity
     * @return flag
     */
    boolean update(BeUserMenu entity);

    /**
     * 保存
     * @param entity
     * @return m
     */
    BeUserMenu save(BeUserMenu entity);

    /**
     * 根据用户查询权限
     * @param userId
     * @return
     */
    List<BeUserMenuVo> queryMenuByUserId(Integer userId);

    /**
     * 保存用户的个人权限
     * @param userId
     * @param menus
     */
    void saveUserMenu(Integer userId, String menus);
}
