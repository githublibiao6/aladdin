package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.vo.ProjectRoleVo;
import com.aladdin.mis.engineering.qo.ProjectRoleQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectRoleService
 * @author cles
 * @date 2021-08-29T23:32:45.167
*/
public interface ProjectRoleService extends GlobalService<ProjectRole>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectRoleVo> paginate(ProjectRoleQo qo);

    /**
     * 删除项目角色
     * @param entity
     * @return flag
     */
    boolean remove(ProjectRole entity);

    /**
     * 更新项目角色
     * @param entity
     * @return flag
     */
    boolean update(ProjectRole entity);

    /**
     * 保存项目角色
     * @param entity
     * @return m
     */
    ProjectRole save(ProjectRole entity);

}
