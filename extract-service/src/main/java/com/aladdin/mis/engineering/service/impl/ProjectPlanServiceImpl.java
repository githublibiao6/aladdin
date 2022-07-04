package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.dao.engineering.ProjectPlanDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectPlanService
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Service
public class ProjectPlanServiceImpl extends GlobalServiceImpl<ProjectPlan> implements ProjectPlanService{

    @Autowired
    private ProjectPlanDao projectPlanDao;

}

