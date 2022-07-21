package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectPlanDao;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectPlanService
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Service
public class ProjectPlanServiceImpl extends GlobalServiceImpl<ProjectPlan> implements ProjectPlanService{

    @Autowired
    private ProjectPlanDao projectPlanDao;


    @Autowired
    private ProjectPlanLogService logService;

    @Override
    public boolean update(ProjectPlan entity) {
        return false;
    }

    @Override
    public boolean save(ProjectPlan entity) {
        if(entity.getId() != null){
            return update(entity);
        }
        // 保存计划
        Integer id = insert(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 新建计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建项目计划"+entity.getPlanName()+";";
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deletePlan(ProjectPlan data) {
        return false;
    }
}

