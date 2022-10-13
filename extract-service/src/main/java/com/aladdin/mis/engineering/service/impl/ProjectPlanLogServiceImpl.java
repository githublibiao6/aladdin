package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.vo.ProjectPlanLogVo;
import com.aladdin.mis.engineering.qo.ProjectPlanLogQo;
import com.aladdin.mis.dao.engineering.ProjectPlanLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectPlanLogService
 * @author cles
 * @date 2022-07-06 23:03:24
*/
public class ProjectPlanLogServiceImpl extends GlobalServiceImpl<ProjectPlanLog> implements ProjectPlanLogService{

    @Autowired
    private ProjectPlanLogDao projectPlanLogDao;

}

