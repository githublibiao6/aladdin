package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectTaskDao;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Map<String, String> map = dictionaryTeamsService.getTeamsByCode("editionStatus");
            content += "状态："+map.get(entity.getStatus());
        }
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

