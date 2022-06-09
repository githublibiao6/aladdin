package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import com.github.pagehelper.PageInfo;
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
}