package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTaskUserService;
import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import com.aladdin.mis.engineering.vo.ProjectTaskUserVo;
import com.aladdin.mis.engineering.qo.ProjectTaskUserQo;
import com.aladdin.mis.dao.engineering.ProjectTaskUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTaskUserService
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@Service
public class ProjectTaskUserServiceImpl extends GlobalServiceImpl<ProjectTaskUser> implements ProjectTaskUserService{

    @Autowired
    private ProjectTaskUserDao projectTaskUserDao;

}

