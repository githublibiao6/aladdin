package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.manager.service.BeUserMenuService;
import com.aladdin.mis.manager.entity.BeUserMenu;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import com.aladdin.mis.manager.qo.BeUserMenuQo;
import com.aladdin.mis.dao.manager.BeUserMenuDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * BeUserMenuService
 * @author cles
 * @date 2022-03-01T22:38:09.336
*/
@Service
public class BeUserMenuServiceImpl extends GlobalServiceImpl<BeUserMenu> implements BeUserMenuService{

    @Autowired
    private BeUserMenuDao beUserMenuDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<BeUserMenuVo> paginate(BeUserMenuQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<BeUserMenuVo> list = beUserMenuDao.list(qo);
       return new PageInfo<>(list);
}
    /**
     * 查询详情
     * @param qo
     * @return
     */
   @Override
    public BeUserMenu detail(BeUserMenu qo){
       return detailQuery(qo.getId());
}
    @Override
    public boolean remove(BeUserMenu entity) {
       return delete(entity);
    }

    @Override
    public boolean update(BeUserMenu entity) {
       return updateSelective(entity);
    }

    @Override
    public BeUserMenu save(BeUserMenu entity) {
       return insertSelective(entity);
    }

}

