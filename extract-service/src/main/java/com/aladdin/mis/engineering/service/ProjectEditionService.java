package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectEdition;
/**
 * ProjectEditionService
 * @author cles
 * @date 2022-05-11T01:37:39.287
*/
public interface ProjectEditionService extends GlobalService<ProjectEdition>  {

    /**
     * 更新数据
     * @param entity
     * @return
     */
    boolean update(ProjectEdition entity);
}
