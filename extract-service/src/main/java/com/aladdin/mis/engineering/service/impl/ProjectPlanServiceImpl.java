package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectPlanDao;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
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
 * ProjectPlanService
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Service
public class ProjectPlanServiceImpl extends GlobalServiceImpl<ProjectPlan> implements ProjectPlanService{

    @Autowired
    private ProjectPlanDao projectPlanDao;

    @Autowired
    private DictionaryTeamsService dictionaryTeamsService;

    @Autowired
    private ProjectPlanLogService logService;

    @Override
    public PageInfo<ProjectPlanVo> pageByDto(ProjectPlanQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<ProjectPlanVo> list = projectPlanDao.list(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean update(ProjectPlan entity) {
        String status = entity.getStatus();
        String target = entity.getTarget();
        ProjectPlan old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();
        String oldTarget = old.getTarget();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectTaskStatus");
        Map<String, String> map2 = dictionaryTeamsService.getTeamsByCode("projectTaskLevel");

        OmUser om = UserUtil.getCurrentUser();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append(map.get(status)).append("计划;");
            if("6".equals(status)){
                entity.setEndTime(LocalDateTime.now());
            }
        }
        if(!oldTarget.equals(target)){
            content.append("修改项目计划目标为：").append(target).append(";");
        }

        if(content.length() > 0){
            ProjectPlanLog log = new ProjectPlanLog();

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
            log.setPlanId(entity.getId());
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectPlan entity) {
        if(entity.getId() != null){
            return update(entity);
        }
        // 保存计划
        Integer id = insert(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 新建计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新建项目计划"+entity.getPlanName()+";";
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean startPlan(ProjectPlan entity) {

        // 开始计划
        entity.setStatus("");
        update(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 开始计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "开始计划"+entity.getPlanName()+";";

        log.setContent(content);
        logService.insert(log);
        return true;
    }


    @Override
    public boolean hangPlan(ProjectPlan entity) {

        // 挂起计划
        entity.setStatus("");
        update(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 挂起计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "挂起计划;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean continuePlan(ProjectPlan entity) {

        // 继续计划
        entity.setStatus("");
        update(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 继续计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "继续计划;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean completePlan(ProjectPlan entity) {

        // 完成计划
        entity.setStatus("");
        update(entity);
        ProjectPlanLog log = new ProjectPlanLog();

        // 完成计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "完成计划"+entity.getPlanName()+";";
        String evaluate = entity.getEvaluate();
        if(evaluate != null && !evaluate.isEmpty()){
            content += "\n完成评价！";
        }
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deletePlan(ProjectPlan entity) {

        // 删除计划
        deleteById(entity.getId());
        ProjectPlanLog log = new ProjectPlanLog();

        // 删除计划日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除计划"+entity.getPlanName()+";";
        String remark = entity.getRemark();
        content += "原因：" + remark+";";
        log.setContent(content);
        logService.insert(log);
        return true;
    }
}

