package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectUserDao;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.engineering.service.ProjectUserService;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.984
*/
@Service
public class ProjectUserServiceImpl extends GlobalServiceImpl<ProjectUser> implements ProjectUserService{

    @Autowired
    private ProjectUserDao projectUserDao;

    @Override
    public PageInfo<ProjectUserVo> pageVoByCondition(ProjectUserQo condition) {

        Integer page = condition.getPage();
        Integer limit = condition.getLimit();
        if (page == null)
            page = 1;
        if(limit == null)
            limit = 10;
        PageHelper.offsetPage(page, limit);

        List<ProjectUserVo> list = projectUserDao.listVo(condition);

        PageInfo<ProjectUserVo> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public boolean addUser(ProjectUser entity) {
        // todo 添加开发用户日志
        return true;
    }

    @Override
    public boolean removeUser(ProjectUser entity) {
        // todo 添加开发用户日志
        return true;
    }
}

