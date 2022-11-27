package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.qo.ProjectEditionQo;
import com.aladdin.mis.engineering.vo.ProjectEditionVo;
import com.github.pagehelper.PageInfo;

/**
 * ProjectEditionService
 * @author cles
 * @date 2022-05-11T01:37:39.287
*/
public interface ProjectEditionService extends GlobalService<ProjectEdition>  {

    /**
     * 获取分页数据
     * @param qo
     * @return
     */
    PageInfo<ProjectEditionVo> pageByDto(ProjectEditionQo qo);

    /**
     * 更新数据
     * @param entity 版本内容
     * @return flag
     */
    boolean update(ProjectEdition entity);

    /**
     * 新建版本
     * @param entity 版本内容
     * @return flag
     */
    boolean save(ProjectEdition entity);

    /**
     * 删除版本
     * @param entity
     * @return
     */
    boolean deleteEdition(ProjectEdition entity);

    /**
     * 作废版本
     * @param entity
     * @return
     */
    boolean cancellation(ProjectEdition entity);

    /**
     * 重启版本
     * @param entity
     * @return
     */
    boolean recover(ProjectEdition entity);
}
