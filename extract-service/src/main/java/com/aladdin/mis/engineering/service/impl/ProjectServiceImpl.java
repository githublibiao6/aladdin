package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectService;
import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.dao.engineering.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
/**
 * ProjectService
 * @author cles
 * @date 2021-08-25T01:30:11.912
*/
@Service
public class ProjectServiceImpl extends GlobalServiceImpl<Project> implements ProjectService{
    @Autowired
    private ProjectDao projectDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<Project> paginate(ProjectQo qo){
       return null;
}
    @Override
    public boolean remove(Project entity) {
        return delete(entity);
    }
    @Override
    public boolean update(Project entity) {
        return updateSelective(entity);
    }
    @Override
    public Project save(Project entity) {
        return insertSelective(entity);
    }
}
