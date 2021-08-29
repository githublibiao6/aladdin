package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectRoleService;
import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.vo.ProjectRoleVo;
import com.aladdin.mis.engineering.qo.ProjectRoleQo;
import com.aladdin.mis.dao.engineering.ProjectRoleDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectRoleService
 * @author cles
 * @date 2021-08-29T23:32:45.168
*/
@Service
public class ProjectRoleServiceImpl extends GlobalServiceImpl<ProjectRole> implements ProjectRoleService{

    @Autowired
    private ProjectRoleDao projectRoleDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectRoleVo> paginate(ProjectRoleQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectRoleVo> list = projectRoleDao.paginate(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(ProjectRole entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectRole entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectRole save(ProjectRole entity) {
        return insertSelective(entity);
    }

}

