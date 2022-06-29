package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTable;
/**
 * ProjectTableService
 * @author cles
 * @date 2021-09-14T00:07:18.683
*/
public interface ProjectTableService extends GlobalService<ProjectTable>  {


    /**
     * 更新
     * @param entity
     * @return
     */
    boolean update(ProjectTable entity);

    /**
     * 保存
     * @param entity
     * @return
     */
    boolean save(ProjectTable entity);

    /**
     * 删除表
     * @param data
     * @return
     */
    boolean deleteTable(ProjectTable data);
}
