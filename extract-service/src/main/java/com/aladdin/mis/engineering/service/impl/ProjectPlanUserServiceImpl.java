package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.dao.engineering.ProjectPlanUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2022-07-05 21:57:37
*/
@Service
public class ProjectPlanUserServiceImpl extends GlobalServiceImpl<ProjectPlanUser> implements ProjectPlanUserService{

    @Autowired
    private ProjectPlanUserDao projectPlanUserDao;

}

