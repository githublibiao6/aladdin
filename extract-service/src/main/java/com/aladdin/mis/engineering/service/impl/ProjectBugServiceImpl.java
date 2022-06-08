package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectBugDao;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.service.ProjectBugService;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectBugService
 * @author cles
 * @date 2022-06-07T00:17:28.398
*/
@Service
public class ProjectBugServiceImpl extends GlobalServiceImpl<ProjectBug> implements ProjectBugService{

    @Autowired
    private ProjectBugDao projectBugDao;

    @Override
    public PageInfo<ProjectBugVo> pageByDto(ProjectBugQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<ProjectBugVo> list = projectBugDao.list(qo);
        return new PageInfo<>(list);
    }
}

