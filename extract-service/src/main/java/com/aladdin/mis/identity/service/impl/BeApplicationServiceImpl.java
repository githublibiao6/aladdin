package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.identity.BeApplicationDao;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.service.BeApplicationService;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import com.aladdin.mis.manager.bean.Menu;
import com.aladdin.mis.system.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BeApplicationService
 * @author cles
 * @date 2024-08-21 03:21:11
*/
@Service
public class BeApplicationServiceImpl extends GlobalServiceImpl<BeApplication> implements BeApplicationService{

    @Autowired
    private BeApplicationDao beApplicationDao;

    @Autowired
    private MenuService menuService;

    @Override
    public PageInfo<BeApplicationVo> page(BeApplicationQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<BeApplicationVo> list = beApplicationDao.list(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean add(BeApplication m) {
        boolean flag = insertSelective(m);
        Menu menu = menuService.getByAppId(m.getId());
        return flag;
    }

    @Override
    public boolean update(BeApplication m) {
        return updateSelective(m);
    }

    @Override
    public boolean remove(Integer id) {
        return  deleteById(id);
    }

    @Override
    public BeApplication getByKeyAndSecret(String appKey, String appSecret) {
        return beApplicationDao.getByKeyAndSecret(appKey, appSecret);
    }
}

