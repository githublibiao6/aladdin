package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.dao.engineering.ProjectPlanDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectPlanService
 * @author cles
 * @date 2021-08-31T22:26:17.069
*/
@Service
public class ProjectPlanServiceImpl extends GlobalServiceImpl<ProjectPlan> implements ProjectPlanService{

    @Autowired
    private ProjectPlanDao projectPlanDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectPlanVo> paginate(ProjectPlanQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectPlanVo> list = projectPlanDao.paginate(qo);
       return new PageInfo<>(list);
}
    /**
     * 查询详情
     * @param qo
     * @return
     */
   @Override
    public ProjectPlan detail(ProjectPlan qo){
       return detailQuery(qo.getId());
}
    @Override
    public boolean remove(ProjectPlan entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectPlan entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectPlan save(ProjectPlan entity) {
        return insertSelective(entity);
    }

}

