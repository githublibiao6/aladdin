package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.vo.ProjectTaskVo;
import com.aladdin.mis.engineering.qo.ProjectTaskQo;
import com.aladdin.mis.dao.engineering.ProjectTaskDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTaskService
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Service
public class ProjectTaskServiceImpl extends GlobalServiceImpl<ProjectTask> implements ProjectTaskService{

    @Autowired
    private ProjectTaskDao projectTaskDao;

}

