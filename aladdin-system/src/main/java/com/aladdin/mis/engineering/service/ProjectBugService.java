package com.aladdin.mis.engineering.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * ProjectBugService
 * @author cles
 * @date 2022-06-07T00:17:28.362
*/
public interface ProjectBugService extends GlobalService<ProjectBug>  {

    /**
     * 获取分页数据
     * @param qo 查询条件
     * @return
     */
    PageInfo<ProjectBugVo> pageByDto(ProjectBugQo qo);

    /**
     * 缺陷内容更新
     * @param entity
     * @return
     */
    boolean update(ProjectBug entity);

    /**
     * 新增缺陷
     * @param entity
     * @return
     */
    boolean save(ProjectBug entity);

    /**
     * 删除缺陷
     * @param entity
     * @return
     */
    boolean deleteBug(ProjectBug entity);

    /**
     * 完成修复缺陷
     * @param entity
     * @return
     */
    boolean completeBug(ProjectBug entity);
}
