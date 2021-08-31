package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.vo.ProjectUserRoleVo;
import com.aladdin.mis.engineering.qo.ProjectUserRoleQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectUserRoleService
 * @author cles
 * @date 2021-08-31T22:03:55.836
*/
public interface ProjectUserRoleService extends GlobalService<ProjectUserRole>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectUserRoleVo> paginate(ProjectUserRoleQo qo);

    /**
     * 删除
     * @param entity
     * @return flag
     */
    boolean remove(ProjectUserRole entity);

    /**
     * 更新
     * @param entity
     * @return flag
     */
    boolean update(ProjectUserRole entity);

    /**
     * 保存
     * @param entity
     * @return m
     */
    ProjectUserRole save(ProjectUserRole entity);

}
