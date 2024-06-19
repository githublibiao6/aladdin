package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.utils.UserUtil;
import com.aladdin.mis.dao.engineering.ProjectFileDao;
import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.engineering.service.ProjectFileLogService;
import com.aladdin.mis.engineering.service.ProjectFileService;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
import com.aladdin.mis.chat.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public PageInfo<ProjectFileVo> pageByDto(ProjectFileQo qo) {
        PageHelper.startPage(qo.getPage(), qo.getLimit());
        List<ProjectFileVo> list = projectFileDao.list(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean update(ProjectFile entity) {
        String status = entity.getStatus();
        ProjectFile old = detailQuery(entity.getId());

        String oldStatus = old.getStatus();

        Map<String, String> map = dictionaryTeamsService.getTeamsByCode("projectFileStatus");
        Map<String, String> levelMap = dictionaryTeamsService.getTeamsByCode("projectFileLevel");

        // 记录版本日志
        String comments = entity.getComments();
        String fileName = entity.getFileName();
        String fileLevel = entity.getFileLevel();

        String oldComments = old.getComments();
        String oldFileName = old.getFileName();
        String oldFileLevel = old.getFileLevel();

        StringBuilder content = new StringBuilder();

        // 判断状态的改变
        if(status != null && !oldStatus.equals(status)){
            content.append("\n修改状态为：").append(map.get(status)).append(";");
        }
        if(comments != null && !oldComments.equals(comments)){
            content.append("\n修改描述为：").append(comments).append(";");
        }
        if(fileName != null && !oldFileName.equals(fileName)){
            content.append("\n修改文件名称为：").append(fileName).append(";");
        }
        if(fileLevel != null && !oldFileLevel.equals(fileLevel)){
            content.append("\n修改文件等级为：").append(levelMap.get(fileLevel)).append(";");
        }

        if(content.length() > 0){
            ProjectFileLog log = new ProjectFileLog();

            // 记录日志的图标
            String statusIcon = status == null ? oldStatus : status;
            switch (statusIcon){
                case "1":
                    log.setType("success");
                    log.setIcon("el-icon-s-flag");
                    break;
                case "0":
                    log.setType("warning");
                    log.setIcon("el-icon-s-opportunity");
                    break;
                default:
                    log.setType("danger");
                    break;
            }

            log.setComments(comments);
            log.setFileId(entity.getId());

            OmUser om = UserUtil.getCurrentUser();
            log.setOperationUser(om.getUserName());
            log.setContent(om.getUserName() + content.toString());
            logService.insert(log);
        }
        return updateSelective(entity);
    }

    @Override
    public boolean save(ProjectFile entity) {
        entity.setDownloadCount(0);
        // 保存文件
        Integer id= insert(entity);
        ProjectFileLog log = new ProjectFileLog();

        // 新建版本日志
        log.setComments(entity.getComments());
        log.setType("success");
        log.setIcon("el-icon-sunrise");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "新上传文件;";

        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean cancellation(ProjectFile entity) {
        ProjectFile data = new ProjectFile();
        data.setStatus("0");
        data.setId(entity.getId());
        updateSelective(data);

        ProjectFileLog log = new ProjectFileLog();

        // 作废文件日志
        log.setType("danger");
        log.setIcon("el-icon-delete");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "作废文件;";
        log.setContent(content);
        logService.insert(log);
        return true;
    }


    @Override
    public boolean recover(ProjectFile entity) {
        ProjectFile data = new ProjectFile();
        data.setStatus("1");
        data.setId(entity.getId());
        updateSelective(data);
        ProjectFileLog log = new ProjectFileLog();

        // 恢复文件日志
        log.setType("info");
        log.setIcon("el-icon-search");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "恢复文件;";
        log.setContent(content);
        logService.insert(log);
        return true;
    }

    @Override
    public boolean deleteFile(ProjectFile entity) {
        String comments = entity.getComments();
        deleteById(entity.getId());
        ProjectFileLog log = new ProjectFileLog();

        // 回复文件日志
        log.setType("danger");
        log.setIcon("el-icon-search");
        OmUser om = UserUtil.getCurrentUser();
        log.setOperationUser(om.getUserName());
        String content = om.getUserName() + "删除文件;";
        content += "删除原因：" + comments;
        log.setContent(content);
        deleteById(entity.getId());
        logService.insert(log);
        return true;
    }

    @Override
    public boolean downloadFile(ProjectFile entity) {
        int count = entity.getDownloadCount();
        count ++;
        entity.setDownloadCount(count);
        update(entity);
        return true;
    }
}

