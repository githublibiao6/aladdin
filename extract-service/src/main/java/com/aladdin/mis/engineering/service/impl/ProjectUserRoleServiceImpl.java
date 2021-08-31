package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectUserRoleService;
import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.vo.ProjectUserRoleVo;
import com.aladdin.mis.engineering.qo.ProjectUserRoleQo;
import com.aladdin.mis.dao.engineering.ProjectUserRoleDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectUserRoleService
 * @author cles
 * @date 2021-08-31T22:03:55.930
*/
@Service
public class ProjectUserRoleServiceImpl extends GlobalServiceImpl<ProjectUserRole> implements ProjectUserRoleService{

    @Autowired
    private ProjectUserRoleDao projectUserRoleDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectUserRoleVo> paginate(ProjectUserRoleQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectUserRoleVo> list = projectUserRoleDao.paginate(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(ProjectUserRole entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectUserRole entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectUserRole save(ProjectUserRole entity) {
        return insertSelective(entity);
    }

}

