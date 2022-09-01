package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectPlanUserDao;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.service.AdminService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2022-07-05 21:57:37
*/
@Service
public class ProjectPlanUserServiceImpl extends GlobalServiceImpl<ProjectPlanUser> implements ProjectPlanUserService{

    @Autowired
    private ProjectPlanUserDao projectPlanUserDao;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProjectPlanLogService logService;


    @Override
    public boolean deleteUser(ProjectPlanUser entity) {
        ProjectPlanLog log = new ProjectPlanLog();

        Admin admin = adminService.detailQuery(entity.getUserId());

        // 删除人员日志
        log.setPlanId(entity.getPlanId());

        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() ;

        content += " 删除人员：" + admin.getRealName()+";";
        String comments = entity.getComments();
        if(comments != null && !comments.isEmpty()){
            content += " 原因：" + entity.getComments() +";";
        }
        log.setContent(content);
        deleteById(entity.getId());
        logService.insert(log);
        return true;
    }
}

