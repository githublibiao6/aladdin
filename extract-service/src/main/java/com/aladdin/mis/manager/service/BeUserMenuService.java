package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.entity.BeUserMenu;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import com.aladdin.mis.manager.qo.BeUserMenuQo;
import com.github.pagehelper.PageInfo;
/**
 * BeUserMenuService
 * @author cles
 * @date 2022-03-01T22:38:09.314
*/
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

}
