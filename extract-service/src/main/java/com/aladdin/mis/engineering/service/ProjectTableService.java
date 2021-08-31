package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.vo.ProjectTableVo;
import com.aladdin.mis.engineering.qo.ProjectTableQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectTableService
 * @author cles
 * @date 2021-08-31T22:04:34.671
*/
public interface ProjectTableService extends GlobalService<ProjectTable>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectTableVo> paginate(ProjectTableQo qo);

    /**
     * 删除项目表
     * @param entity
     * @return flag
     */
    boolean remove(ProjectTable entity);

    /**
     * 更新项目表
     * @param entity
     * @return flag
     */
    boolean update(ProjectTable entity);

    /**
     * 保存项目表
     * @param entity
     * @return m
     */
    ProjectTable save(ProjectTable entity);

}
