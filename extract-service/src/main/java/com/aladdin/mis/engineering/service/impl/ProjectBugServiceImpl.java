package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.common.utils.UserUtil;
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
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<ProjectBugVo> list = projectBugDao.list(qo);
        return new PageInfo<>(list);
    }


    @Override
    public boolean update(ProjectBug entity) {
        String status = entity.getStatus();
        ProjectBug old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectBugStatus");

        OmUser om = UserUtil.getCurrentUser();

        StringBuilder content = new StringBuilder();

        content.append(om.getUserName());
        // 判断状态的改变
        if(!oldStatus.equals(status)){
            content.append("修改状态为：").append(map.get(status)).append(";");
        }

        if(content.length() > 0){
            ProjectBugLog log = new ProjectBugLog();

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

            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectBug entity) {
        // 保存版本
        Integer id= insert(entity);
        ProjectBugLog log = new ProjectBugLog();

        // 新建缺陷管理日志
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "打开缺陷;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }
}

