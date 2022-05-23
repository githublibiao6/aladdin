package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectEditionDao;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import com.aladdin.mis.engineering.service.ProjectEditionLogService;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ProjectEditionService
 * @author cles
 * @date 2022-05-11T01:37:39.288
*/
@Service
public class ProjectEditionServiceImpl extends GlobalServiceImpl<ProjectEdition> implements ProjectEditionService{

    @Autowired
    private ProjectEditionDao projectEditionDao;

    @Autowired
    private ProjectEditionLogService logService;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Override
    public boolean update(ProjectEdition entity) {
        String status = entity.getStatus();
        ProjectEdition old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();

        if("1".equals(old.getStatus()) && "2".equals(status)){
            entity.setStartDate(LocalDateTime.now());
        }
        if("4".equals(status)){
            entity.setEndDate(LocalDateTime.now());
        }

        // 状态不允许回头
//
        // 验收后发现问题的回调
        if("4".equals(oldStatus) && "3".equals(status)){
            entity.setStatus(status);
        }
        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("editionStatus");

        // 记录版本日志
        String comments = entity.getComments();
        String versionContent = entity.getVersionContent();

        String oldComments = old.getComments();
        String oldVersionContent = old.getVersionContent();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append("\n修改状态为：").append(map.get(status)).append(";");
        }
        if(comments != null && !oldComments.equals(comments)){
            content.append("\n修改描述为：").append(comments).append(";");
        }
        if(versionContent != null && !oldVersionContent.equals(versionContent)){
            content.append("\n修改版本内容为：").append(versionContent).append(";");
        }

        if(content.length() > 0){
            ProjectEditionLog log = new ProjectEditionLog();

            // 记录日志的图标
            String statusIcon = status == null ? oldStatus : status;
            switch (statusIcon){
                case "4":
                    log.setType("success");
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

            log.setVersionContent(versionContent);
            log.setComments(comments);
            log.setEditionId(entity.getId());

            OmUser om = UserUtil.getCurrentUser();
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }

        // todo 记录版本日志
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectEdition entity) {
        // 保存版本
        Integer id= insert(entity);
        ProjectEditionLog log = new ProjectEditionLog();

        // 新建版本日志
        log.setVersionContent(entity.getVersionContent());
        log.setComments(entity.getComments());
        log.setEditionId(id);
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        log.setContent(om.getUserName() + "新建版本");
        logService.insert(log);
        return true;
    }
}

