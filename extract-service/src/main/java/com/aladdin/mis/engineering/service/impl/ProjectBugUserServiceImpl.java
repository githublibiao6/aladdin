package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectBugUserDao;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.entity.ProjectBugLog;
import com.aladdin.mis.engineering.entity.ProjectBugUser;
import com.aladdin.mis.engineering.service.ProjectBugLogService;
import com.aladdin.mis.engineering.service.ProjectBugService;
import com.aladdin.mis.engineering.service.ProjectBugUserService;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.service.AdminService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ProjectBugUserService
 * @author cles
 * @date 2022-06-07T00:17:46.099
*/
@Service
public class ProjectBugUserServiceImpl extends GlobalServiceImpl<ProjectBugUser> implements ProjectBugUserService{

    @Autowired
    private ProjectBugUserDao projectBugUserDao;

    @Autowired
    private ProjectBugLogService logService;

    @Autowired
    private ProjectBugService bugService;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private AdminService adminService;

    @Override
    public boolean save(ProjectBugUser entity) {
        // 保存缺陷管理人员
        Integer id = insert(entity);
        ProjectBugLog log = new ProjectBugLog();

        Admin admin = adminService.detailQuery(entity.getUserId());

        // 新建缺陷管理日志
        log.setBugId(entity.getBugId());

        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() ;
        if("1".equals(entity.getUserType())){
            log.setType("success");
            log.setIcon("el-icon-document");
            content += " 指派任务至" + admin.getRealName()+";";
        }else {
            log.setType("info");
            log.setIcon("el-icon-phone");
            content += " 邀请" + admin.getRealName()+"协助任务;";
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
    public boolean update(ProjectBugUser entity) {
        // 保存缺陷管理人员

        ProjectBugUser old = detailQuery(entity.getId());

        ProjectBugLog log = new ProjectBugLog();

        // 新建缺陷管理日志
        log.setBugId(entity.getBugId());

        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());

        String content = om.getUserName() ;
        ProjectBug bug = bugService.detailQuery(old.getBugId());

        if("1".equals(old.getStatus()) && "2".equals(entity.getStatus())){
            log.setType("info");
            log.setIcon("el-icon-caret-right");
            entity.setStartTime(LocalDateTime.now());
            content += "开始处理任务";
        }else if("2".equals(old.getStatus()) && "3".equals(entity.getStatus())){
            log.setType("success");
            log.setIcon("el-icon-folder-checked");
            entity.setEndTime(LocalDateTime.now());
            content += "提测任务";
            // 指派人员完成任务时， 修改缺陷的状态(指派人员确定缺陷的状态)
            bug.setStatus("3");
        }else if("3".equals(old.getStatus()) && "4".equals(entity.getStatus())){
            log.setType("success");
            log.setIcon("el-icon-folder-checked");
            content += "复提任务";
            // 指派人员完成任务时， 修改缺陷的状态(指派人员确定缺陷的状态)
            bug.setStatus("5");
        }
        bugService.updateSelective(bug);
        log.setContent(content);
        logService.insert(log);
        return updateSelective(entity);
    }
}

