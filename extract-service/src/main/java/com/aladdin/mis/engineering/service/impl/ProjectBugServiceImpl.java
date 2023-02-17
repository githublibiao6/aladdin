package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectBugDao;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.entity.ProjectBugLog;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.service.ProjectBugLogService;
import com.aladdin.mis.engineering.service.ProjectBugService;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * ProjectBugService
 * @author cles
 * @date 2022-06-07T00:17:28.398
*/
@Service
public class ProjectBugServiceImpl extends GlobalServiceImpl<ProjectBug> implements ProjectBugService{

    @Autowired
    private ProjectBugDao projectBugDao;

    @Autowired
    private ProjectBugLogService logService;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Override
    public PageInfo<ProjectBugVo> pageByDto(ProjectBugQo qo) {
        PageHelper.startPage(qo.getPage(), qo.getLimit());
        // todo 根据人员来获取
        List<ProjectBugVo> list = projectBugDao.list(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean update(ProjectBug entity) {
        String status = entity.getStatus();
        String level = entity.getBugLevel();
        String priority = entity.getBugPriority();
        ProjectBug old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();
        String oldLevel = old.getBugLevel();
        String oldPriority = old.getBugPriority();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectBugStatus");
        Map<String, String> map2 = dictionaryTeamsService.getTeamsByCode("projectBugLevel");
        Map<String, String> map3 = dictionaryTeamsService.getTeamsByCode("projectBugPriority");

        OmUser om = UserUtil.getCurrentUser();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append(map.get(status)).append("任务;");
            if("6".equals(status)){
                entity.setCompleteTime(LocalDateTime.now());
            }else if("5".equals(status)){
                if(entity.getRegressionComments() != null && !entity.getRegressionComments().isEmpty()){
                    content.append("复提问题/意见：").append(entity.getRegressionComments()).append(";");
                }
            }
        }
        if(!oldLevel.equals(level)){
            content.append("修改等级为：").append(map2.get(level)).append(";");
        }
        if(!oldPriority.equals(priority)){
            content.append("修改优先级为：").append(map3.get(priority)).append(";");
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
    public boolean save(ProjectBug entity) {
        OmUser om = UserUtil.getCurrentUser();
        entity.setFoundUser(om.getUserName());
        // 保存缺陷
        Integer id= insert(entity);
        ProjectBugLog log = new ProjectBugLog();

        // 打开缺陷管理日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        log.setBugId(id);

        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "打开缺陷;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deleteBug(ProjectBug entity) {
        OmUser om = UserUtil.getCurrentUser();
        entity.setFoundUser(om.getUserName());

        ProjectBugLog log = new ProjectBugLog();

        // 删除缺陷管理日志
        log.setType("danger");
        log.setIcon("el-icon-sunrise");
        log.setBugId(entity.getId());

        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除缺陷;";
        content += "原因：" + entity.getCompleteStar()+";";
        log.setContent(content);
        logService.insert(log);
        // 删除缺陷
        deleteById(entity.getId());
        return true;
    }

    @Override
    public boolean completeBug(ProjectBug entity) {
        OmUser om = UserUtil.getCurrentUser();
        entity.setFoundUser(om.getUserName());

        ProjectBugLog log = new ProjectBugLog();

        // 完成缺陷管理日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        log.setBugId(entity.getId());

        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "完成缺陷修复;";

        log.setContent(content);
        logService.insert(log);
        // 完成缺陷
        deleteById(entity.getId());
        return true;
    }
}

