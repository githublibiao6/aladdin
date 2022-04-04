package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.vo.ProjectVo;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.github.pagehelper.PageInfo;

/**
 * ProjectService
 * @author cles
 * @date 2021-08-26T23:02:39.366
*/
public interface ProjectService extends GlobalService<Project>  {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectVo> paginate(ProjectQo qo);

    /**
     * 删除工程项目
     * @param entity
     * @return flag
     */
    boolean remove(Project entity);

    /**
     * 更新工程项目
     * @param entity
     * @return flag
     */
    boolean update(Project entity);

    /**
     * 保存工程项目
     * @param entity
     * @return m
     */
    Project save(Project entity);

}
