package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectBugUserService;
import com.aladdin.mis.engineering.entity.ProjectBugUser;
import com.aladdin.mis.engineering.vo.ProjectBugUserVo;
import com.aladdin.mis.engineering.qo.ProjectBugUserQo;
import com.aladdin.mis.dao.engineering.ProjectBugUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectBugUserService
 * @author cles
 * @date 2022-06-07T00:17:46.099
*/
@Service
public class ProjectBugUserServiceImpl extends GlobalServiceImpl<ProjectBugUser> implements ProjectBugUserService{

    @Autowired
    private ProjectBugUserDao projectBugUserDao;

}

