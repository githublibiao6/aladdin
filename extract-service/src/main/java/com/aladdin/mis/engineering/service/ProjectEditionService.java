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
     * @param entity 版本内容
     * @return flag
     */
    boolean update(ProjectEdition entity);

    /**
     * 新建版本
     * @param entity 版本内容
     * @return flag
     */
    boolean save(ProjectEdition entity);

    /**
     * 作废版本
     * @param entity
     * @return
     */
    boolean cancellation(ProjectEdition entity);
}
