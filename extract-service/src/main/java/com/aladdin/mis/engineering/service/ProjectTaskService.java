package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.common.utils.UserUtil;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.manager.service.DictionaryTeamsService;
import com.aladdin.mis.system.user.vo.OmUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * ProjectTaskService
 * @author cles
 * @date 2022-07-05 21:58:00
*/
public interface ProjectTaskService extends GlobalService<ProjectTask>  {


    boolean save(ProjectTask entity);
}
