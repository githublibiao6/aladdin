package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.identity.BeApplicationDao;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.service.BeApplicationService;
import com.aladdin.mis.identity.service.DeptService;
import com.aladdin.mis.identity.service.MenuService;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import com.aladdin.mis.system.user.vo.OmUser;
import com.aladdin.mis.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private DeptService deptService;

    @Value("${global.appKey:0}")
    private  String appKey;

    @Value("${global.appSecret:0}")
    private String appSecret;

    @Override
    public PageInfo<BeApplicationVo> page(BeApplicationQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<BeApplicationVo> list = beApplicationDao.list(qo);
        return new PageInfo<>(list);
    }

    @Override
    public List<BeApplicationVo> listInfo(BeApplicationQo qo) {
        return beApplicationDao.list(qo);
    }

    @Override
    public boolean add(BeApplication m) {
        BeApplication application = insertSelective(m);

        menuService.saveApplicationMenu(application);
        deptService.saveApplicationDept(application);

        return application != null;
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
    public BeApplication getByKeyAndSecret() {
        return beApplicationDao.getByKeyAndSecret(appKey, appSecret);
    }

    @Override
    public List<BeApplicationVo> getByAdminId() {
        OmUser omUser = UserUtil.getCurrentUser();
        return beApplicationDao.getByAdminId(omUser.getDeptId());
    }
}

