package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectTableFieldDao;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import com.aladdin.mis.system.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@Service
public class ProjectTableFieldServiceImpl extends GlobalServiceImpl<ProjectTableField> implements ProjectTableFieldService{

    @Autowired
    private ProjectTableFieldDao projectTableFieldDao;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private ProjectTableLogService logService;

    @Override
    public boolean update(ProjectTableField entity) {
        String status = entity.getStatus();
        ProjectTableField old = detailQuery(entity.getId());


        String oldStatus = old.getStatus();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectTableStatus");
        Map<String, String> map2 = dictionaryTeamsService.getTeamsByCode("columnType");

        // 记录日志
        String comments = entity.getColumnComment();
        String columnName = entity.getColumnName();
        String columnType = entity.getColumnType();
        Integer columnLength = entity.getColumnLength();

        String abandonReason = entity.getAbandonReason();

        String oldComments = old.getColumnComment();
        String oldColumnName = old.getColumnName();
        String oldColumnType = old.getColumnType();
        Integer oldColumnLength = old.getColumnLength();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append("\n修改字段状态为：").append(map.get(status)).append(";");
            if("0".equals(status)){
                content.append("字段废弃原因：").append(abandonReason).append(";");
            }
        }
        if(comments != null && !oldComments.equals(comments)){
            content.append("\n修改字段描述为：").append(comments).append(";");
        }
        if(columnName != null && !oldColumnName.equals(columnName)){
            content.append("\n修改字段名称为：").append(columnName).append(";");
        }
        if(columnType != null && !oldColumnType.equals(columnType)){
            content.append("\n修改字段类型为：").append(map2.get(columnType)).append(";");
        }
        if(columnLength != null && !oldColumnLength.equals(columnLength)){
            content.append("\n修改字段长度为：").append(columnLength).append(";");
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

            OmUser om = UserUtil.getCurrentUser();
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectTableField entity) {
        if(entity.getId() != null){
            return update(entity);
        }
        // 保存字段
        Integer id = insert(entity);
        ProjectTableLog log = new ProjectTableLog();

        // 新建表字段日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建表字段"+entity.getTableName()+";";
        content += "字段描述为" +entity.getColumnComment()+ ";";
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deleteField(ProjectTableField data) {
        Integer id = data.getId();
        String abandonReason = data.getAbandonReason();
        ProjectTableField entity = detailQuery(id);
        if(id == null){
            return false;
        }
        // 删除字段
        deleteById(id);
        ProjectTableLog log = new ProjectTableLog();

        // 删除表字段日志
        log.setType("warning");
        log.setIcon("el-icon-message-solid");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除表字段"+entity.getColumnName();
        String comment = entity.getColumnComment();
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

