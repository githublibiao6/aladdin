package com.aladdin.mis.engineering.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.engineering.vo.ProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

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

    /**
     * 删除工程项目
     * @param entity
     * @return m
     */
    boolean deleteProject(Project entity);

    /**
     * 开始工程
     * @param entity
     * @return
     */
    boolean startProject(Project entity);

    /**
     * 挂起工程
     * @param entity
     * @return
     */
    boolean hang(Project entity);

    /**
     * 挂起工程
     * @param entity
     * @return
     */
    boolean continueProject(Project entity);

    /**
     * 完成工程
     * @param entity
     * @return
     */
    boolean complete(Project entity);
}
