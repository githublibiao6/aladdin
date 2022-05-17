package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectEditionDao;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ProjectEditionService
 * @author cles
 * @date 2022-05-11T01:37:39.288
*/
@Service
public class ProjectEditionServiceImpl extends GlobalServiceImpl<ProjectEdition> implements ProjectEditionService{

    @Autowired
    private ProjectEditionDao projectEditionDao;

    @Override
    public boolean update(ProjectEdition entity) {
        String status = entity.getStatus();
        ProjectEdition old = detailQuery(entity.getId());
        if("1".equals(old.getStatus()) && "2".equals(status)){
            entity.setStartDate(LocalDateTime.now());
        }
        if("4".equals(status)){
            entity.setEndDate(LocalDateTime.now());
        }

        // 状态不允许回头
        if(Integer.parseInt(old.getStatus()) > Integer.parseInt(entity.getStatus())){
            entity.setStatus(null);
        }
        // 验收后发现问题的回调
        if("4".equals(old.getStatus()) && "3".equals(status)){
            entity.setStatus(status);
        }
        // todo 记录版本日志
        return updateSelective(entity);
    }
}

