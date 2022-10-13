package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.vo.ProjectTaskLogVo;
import com.aladdin.mis.engineering.qo.ProjectTaskLogQo;
import com.aladdin.mis.dao.engineering.ProjectTaskLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTaskLogService
 * @author cles
 * @date 2022-07-05 21:58:10
*/
public class ProjectTaskLogServiceImpl extends GlobalServiceImpl<ProjectTaskLog> implements ProjectTaskLogService{

    @Autowired
    private ProjectTaskLogDao projectTaskLogDao;

}

