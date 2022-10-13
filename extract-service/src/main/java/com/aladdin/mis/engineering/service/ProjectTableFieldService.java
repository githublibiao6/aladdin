package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import org.springframework.stereotype.Service;

/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@Service
public interface ProjectTableFieldService extends GlobalService<ProjectTableField>  {

    /**
     * 更新数据
     * @param entity
     * @return
     */
    boolean update(ProjectTableField entity);

    /**
     * 保存数据
     * @param entity
     * @return
     */
    boolean save(ProjectTableField entity);

    /**
     * 删除实体字段
     * @param data
     * @return
     */
    boolean deleteField(ProjectTableField data);
}
