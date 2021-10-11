package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectUserService;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.dao.engineering.ProjectUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.984
*/
@Service
public class ProjectUserServiceImpl extends GlobalServiceImpl<ProjectUser> implements ProjectUserService{

    @Autowired
    private ProjectUserDao projectUserDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectUserVo> paginate(ProjectUserQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectUserVo> list = projectUserDao.list(qo);
       return new PageInfo<>(list);
}
    /**
     * 查询详情
     * @param qo
     * @return
     */
   @Override
    public ProjectUser detail(ProjectUser qo){
       return detailQuery(qo.getId());
}
    @Override
    public boolean remove(ProjectUser entity) {
       return delete(entity);
    }

    @Override
    public boolean update(ProjectUser entity) {
       return updateSelective(entity);
    }

    @Override
    public ProjectUser save(ProjectUser entity) {
       return insertSelective(entity);
    }

}

