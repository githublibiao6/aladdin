package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.903
*/
public interface ProjectUserService extends GlobalService<ProjectUser>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectUserVo> paginate(ProjectUserQo qo);

    /**
     * 查询详情
     * @param qo
     * @return entity
     */
    ProjectUser detail(ProjectUser qo);

    /**
     * 删除
     * @param entity
     * @return flag
     */
    boolean remove(ProjectUser entity);

    /**
     * 更新
     * @param entity
     * @return flag
     */
    boolean update(ProjectUser entity);

    /**
     * 保存
     * @param entity
     * @return m
     */
    ProjectUser save(ProjectUser entity);

}
