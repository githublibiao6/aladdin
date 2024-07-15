package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectTaskUserDao;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import com.aladdin.mis.engineering.service.ProjectTaskUserService;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.bill.service.AdminService;
import com.aladdin.mis.bill.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ProjectTaskUserService
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@Service
public class ProjectTaskUserServiceImpl extends GlobalServiceImpl<ProjectTaskUser> implements ProjectTaskUserService{

    @Autowired
    private ProjectTaskUserDao projectTaskUserDao;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private ProjectTaskLogService logService;

    @Autowired
    private AdminService adminService;

    @Override
    public boolean save(ProjectTaskUser entity) {
        // 保存项目任务人员
        Integer id = insert(entity);
        ProjectTaskLog log = new ProjectTaskLog();

        Admin admin = adminService.detailQuery(entity.getUserId());

        // 新建项目任务日志
        log.setTaskId(entity.getTaskId());

        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() ;
        if("1".equals(entity.getUserType())){
            log.setType("success");
            log.setIcon("el-icon-document");
            content += " 指派项目任务至" + admin.getRealName()+";";
        }else {
            log.setType("info");
            log.setIcon("el-icon-phone");
            content += " 邀请" + admin.getRealName()+"协助项目任务;";
        }
        entity.setStatus("1");
        if(!"0".equals(entity.getStatus())){
            Map<String, String> map = dictionaryTeamsService.getTeamsByCode("editionStatus");
            content += "状态："+map.get(entity.getStatus());
        }
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {

        OmUser om = UserUtil.getCurrentUser();
        ProjectTaskUser taskUser = projectTaskUserDao.getByTaskAndUserId(id, om.getUserId());

        int userId = taskUser.getUserId();
        Admin admin = adminService.detailQuery(userId);

        // 删除人员
        taskUser.setStatus("");
        updateSelective(taskUser);
        // 保存日志
        ProjectTaskLog log = new ProjectTaskLog();

        // 保存日志记录
        log.setTaskId(id);
        log.setType("info");
        log.setIcon("el-icon-sunrise");
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除人员"+admin.getRealName()+";";

        log.setContent(content);
        logService.insert(log);
        return true;

    }

}

