package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.dao.engineering.ProjectPlanUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2021-08-29T23:32:31.976
*/
@Service
public class ProjectPlanUserServiceImpl extends GlobalServiceImpl<ProjectPlanUser> implements ProjectPlanUserService{

    @Autowired
    private ProjectPlanUserDao projectPlanUserDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectPlanUserVo> paginate(ProjectPlanUserQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectPlanUserVo> list = projectPlanUserDao.paginate(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(ProjectPlanUser entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectPlanUser entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectPlanUser save(ProjectPlanUser entity) {
        return insertSelective(entity);
    }

}

