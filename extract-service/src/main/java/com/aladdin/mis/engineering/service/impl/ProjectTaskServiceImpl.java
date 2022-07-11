package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectTaskDao;
import com.aladdin.mis.engineering.entity.*;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ProjectTaskService
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Service
public class ProjectTaskServiceImpl extends GlobalServiceImpl<ProjectTask> implements ProjectTaskService{

    @Autowired
    private ProjectTaskDao projectTaskDao;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private ProjectTaskLogService logService;

    @Override
    public boolean update(ProjectTask entity) {
        String status = entity.getStatus();
        Integer level = entity.getTaskLevel();
        String target = entity.getTarget();
        String comments = entity.getTaskComments();
        String name = entity.getTaskName();
        ProjectTask old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();
        Integer oldLevel = old.getTaskLevel();
        String oldTarget = old.getTarget();
        String oldComments = old.getTaskComments();
        String oldName = entity.getTaskName();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectTaskStatus");
        Map<String, String> map2 = dictionaryTeamsService.getTeamsByCode("projectTaskLevel");

        OmUser om = UserUtil.getCurrentUser();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append(map.get(status)).append("任务;");
            if("6".equals(status)){
                entity.setEndTime(LocalDateTime.now());
            }
        }
        if(!oldLevel.equals(level)){
            content.append("修改等级为：").append(map2.get(String.valueOf(level))).append(";");
        }
        if(!oldTarget.equals(target)){
            content.append("修改任务目标为：").append(target).append(";");
        }
        if(!oldComments.equals(comments)){
            content.append("修改任务描述为：").append(comments).append(";");
        }
        if(!oldName.equals(name)){
            content.append("修改任务名称为：").append(name).append(";");
        }

        if(content.length() > 0){
            ProjectBugLog log = new ProjectBugLog();

            // 记录日志的图标
            String statusIcon = status == null ? oldStatus : status;
            switch (statusIcon){
                case "6":
                    log.setType("success");
                    log.setIcon("el-icon-s-promotion");
                    break;
                case "5":
                    log.setType("success");
                    log.setIcon("el-icon-refresh-left");
                    break;
                case "4":
                    log.setType("danger");
                    log.setIcon("el-icon-s-promotion");
                    break;
                case "3":
                    log.setType("warning");
                    log.setIcon("el-icon-message-solid");
                    break;
                case "2":
                    log.setType("primary");
                    log.setIcon("el-icon-s-flag");
                    break;
                case "1":
                    log.setType("info");
                    log.setIcon("el-icon-search");
                    break;
                case "0":
                    log.setType("");
                    log.setIcon("el-icon-s-opportunity");
                    break;
                default:
                    log.setType("danger");
                    break;
            }
            log.setBugId(entity.getId());
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectTask entity) {
        // 保存任务
        Integer id= insert(entity);
        ProjectTaskLog log = new ProjectTaskLog();

        // 新建版本日志
        log.setTaskId(id);
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建任务;";
        if(!"0".equals(entity.getStatus())){
            Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectTaskStatus");
            content += "状态："+map.get(entity.getStatus());
        }
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean hangTask(Integer id) {
        ProjectTask task = new ProjectTask();
        task.setId(id);
        // 挂起状态
        task.setStatus("");
        updateSelective(task);
        // 保存日志
        ProjectTaskLog log = new ProjectTaskLog();

        // 保存日志记录
        log.setTaskId(id);
        log.setType("info");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "挂起任务;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean continueTask(Integer id) {
        ProjectTask task = new ProjectTask();
        task.setId(id);
        // 挂起状态
        task.setStatus("");
        updateSelective(task);
        // 保存日志
        ProjectTaskLog log = new ProjectTaskLog();

        // 保存日志记录
        log.setTaskId(id);
        log.setType("info");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "继续任务;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }


    @Override
    public boolean deleteTask(ProjectTask data) {
        Integer id = data.getId();
        String abandonReason = data.getTaskComments();
        ProjectTask entity = detailQuery(id);
        if(id == null){
            return false;
        }
        // 删除任务
        deleteById(id);
        ProjectTableLog log = new ProjectTableLog();

        // 删除任务日志
        log.setType("warning");
        log.setIcon("el-icon-message-solid");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除任务"+entity.getTaskName();

        content += ";";
        if(abandonReason != null && !abandonReason.isEmpty()){
            content += "删除原因："+ abandonReason +";";
        }
        log.setContent(content);
        logService.insert(log);
        return true;
    }
}

