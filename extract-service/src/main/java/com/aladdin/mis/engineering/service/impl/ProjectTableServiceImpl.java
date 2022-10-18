package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectTableDao;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import com.aladdin.mis.engineering.service.ProjectTableService;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ProjectTableService
 * @author cles
 * @date 2021-09-14T00:07:18.685
*/
@Service
public class ProjectTableServiceImpl extends GlobalServiceImpl<ProjectTable> implements ProjectTableService{

    @Autowired
    private ProjectTableDao projectTableDao;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private ProjectTableLogService logService;


    @Override
    public boolean update(ProjectTable entity) {
        String status = entity.getStatus();
        ProjectTable old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectTableStatus");

        // 记录日志
        String comments = entity.getTableComment();
        String remark = entity.getRemark();
        String abandonReason = entity.getAbandonReason();

        String oldComments = old.getTableComment();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append("\n修改表状态为：").append(map.get(status)).append(";");
            if("0".equals(status)){
                content.append("表废弃原因：").append(abandonReason).append(";");
            }
        }
        if(comments != null && !oldComments.equals(comments)){
            content.append("\n修改表描述为：").append(comments).append(";");
        }

        if(content.length() > 0){
            ProjectTableLog log = new ProjectTableLog();

            // 记录日志的图标
            String statusIcon = status == null ? oldStatus : status;
            switch (statusIcon){
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
            if(remark != null && !remark.isEmpty()){
                content.append("\n修改表原因：").append(remark);
            }

            OmUser om = UserUtil.getCurrentUser();
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectTable entity) {
        if(entity.getId() != null){
            return update(entity);
        }
        // 保存项目表
        Integer id = insert(entity);
        ProjectTableLog log = new ProjectTableLog();

        // 新建项目表日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建项目表"+entity.getTableName()+";";
        content += "表描述为" +entity.getTableComment()+ ";";
        log.setContent(content);
        logService.insert(log);
        return true;
    }


    @Override
    public boolean deleteTable(ProjectTable data) {
        Integer id = data.getId();
        String abandonReason = data.getAbandonReason();
        ProjectTable entity = detailQuery(id);
        if(id == null){
            return false;
        }
        // 删除表
        deleteById(id);
        ProjectTableLog log = new ProjectTableLog();

        // 删除表日志
        log.setType("warning");
        log.setIcon("el-icon-message-solid");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除表"+entity.getTableName();
        String comment = entity.getTableComment();
        if(comment != null && !comment.isEmpty()){
            content += "（"+comment+")";
        }
        content += ";";
        if(abandonReason != null && !abandonReason.isEmpty()){
            content += "删除原因："+ abandonReason +";";
        }
        log.setContent(content);
        logService.insert(log);
        return true;
    }


}

