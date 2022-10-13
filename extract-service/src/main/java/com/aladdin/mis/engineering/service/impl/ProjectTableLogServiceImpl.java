package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.vo.ProjectTableLogVo;
import com.aladdin.mis.engineering.qo.ProjectTableLogQo;
import com.aladdin.mis.dao.engineering.ProjectTableLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTableLogService
 * @author cles
 * @date 2022-06-22T21:14:00.937
*/
public class ProjectTableLogServiceImpl extends GlobalServiceImpl<ProjectTableLog> implements ProjectTableLogService{

    @Autowired
    private ProjectTableLogDao projectTableLogDao;

}

