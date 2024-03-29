package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectService;
import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.vo.ProjectVo;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.dao.engineering.ProjectDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
/**
 * ProjectService
 * @author cles
 * @date 2021-08-26T23:02:39.367
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
    public PageInfo<ProjectVo> paginate(ProjectQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectVo> list = projectDao.list(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(Project entity) {
        return delete(entity);
    }

    @Override
    public boolean update(Project entity) {
       Project m = detailQuery(entity.getId());
       String oldStatus = m.getStatus();
       String status = entity.getStatus();
       // 项目只能更新为下一级？
       if(status.compareTo(oldStatus) <= 0){
           entity.setStatus(oldStatus);
       }
       if("0".equals(oldStatus) && "1".equals(status)){
           entity.setStartDate(new Date());
       }
       return updateSelective(entity);
    }

    @Override
    public Project save(Project entity) {
        return insertSelective(entity);
    }

}

