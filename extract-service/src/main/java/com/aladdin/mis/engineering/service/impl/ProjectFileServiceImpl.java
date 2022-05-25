package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectFileDao;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.service.ProjectFileLogService;
import com.aladdin.mis.engineering.service.ProjectFileService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ProjectFileService
 * @author cles
 * @date 2022-05-25T00:29:11.439
*/
@Service
public class ProjectFileServiceImpl extends GlobalServiceImpl<ProjectFile> implements ProjectFileService{

    @Autowired
    private ProjectFileDao projectFileDao;

    @Autowired
    private ProjectFileLogService logService;


    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Override
    public boolean update(ProjectFile entity) {
        String status = entity.getStatus();
        ProjectFile old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();


        // 验收后发现问题的回调
        if("4".equals(oldStatus) && "3".equals(status)){
            entity.setStatus(status);
        }
        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("editionStatus");

        // 记录版本日志
        String comments = entity.getComments();

        String oldComments = old.getComments();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append("\n修改状态为：").append(map.get(status)).append(";");
        }
        if(comments != null && !oldComments.equals(comments)){
            content.append("\n修改描述为：").append(comments).append(";");
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

            log.setComments(comments);
            log.setEditionId(entity.getId());

            OmUser om = UserUtil.getCurrentUser();
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectFile entity) {
        // 保存版本
        Integer id= insert(entity);
        ProjectFileLog log = new ProjectFileLog();

        // 新建版本日志
        log.setComments(entity.getComments());
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建版本;";
        if(!"0".equals(entity.getStatus())){
            Map<String, String> map = dictionaryTeamsService.getTeamsByCode("editionStatus");
            content += "状态："+map.get(entity.getStatus());
        }
        log.setContent(content);
        logService.insert(log);/**/
        return true;
    }

    @Override
    public boolean cancellation(ProjectFile entity) {
        ProjectEdition data = new ProjectEdition();
        data.setStatus("9");
        data.setId(entity.getId());
        updateSelective(data);

        ProjectFileLog log = new ProjectFileLog();

        // 作废文件日志
        log.setType("danger");
        log.setIcon("el-icon-delete");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "作废版本;";
        log.setContent(content);
        logService.insert(log);
        return true;
    }


    @Override
    public boolean recover(ProjectFile entity) {
        ProjectEdition data = new ProjectEdition();
        data.setStatus("1");
        data.setId(entity.getId());
        updateSelective(data);
        ProjectFileLog log = new ProjectFileLog();

        // 回复文件日志
        log.setType("info");
        log.setIcon("el-icon-search");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "重启版本;";
        log.setContent(content);
        logService.insert(log);
        return true;
    }
}

