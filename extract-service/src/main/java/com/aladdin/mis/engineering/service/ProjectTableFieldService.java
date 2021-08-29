package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.vo.ProjectTableFieldVo;
import com.aladdin.mis.engineering.qo.ProjectTableFieldQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-29T23:33:00.409
*/
public interface ProjectTableFieldService extends GlobalService<ProjectTableField>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectTableFieldVo> paginate(ProjectTableFieldQo qo);

    /**
     * 删除项目表字段
     * @param entity
     * @return flag
     */
    boolean remove(ProjectTableField entity);

    /**
     * 更新项目表字段
     * @param entity
     * @return flag
     */
    boolean update(ProjectTableField entity);

    /**
     * 保存项目表字段
     * @param entity
     * @return m
     */
    ProjectTableField save(ProjectTableField entity);

}
