package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.github.pagehelper.PageInfo;

/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.903
*/
public interface ProjectUserService extends GlobalService<ProjectUser>  {

    /**
     * 获取分页信息
     * @param condition
     * @return
     */
    PageInfo<ProjectUserVo> pageVoByCondition(ProjectUserQo condition);

    /**
     * 添加项目开饭人员
     * @param entity
     * @return
     */
    Boolean addUser(ProjectUser entity);

    /**
     * 移除项目开饭人员
     * @param entity
     * @return
     */
    boolean removeUser(ProjectUser entity);
}
