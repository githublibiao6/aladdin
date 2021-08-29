package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTableService;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.vo.ProjectTableVo;
import com.aladdin.mis.engineering.qo.ProjectTableQo;
import com.aladdin.mis.dao.engineering.ProjectTableDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTableService
 * @author cles
 * @date 2021-08-29T23:32:52.589
*/
@Service
public class ProjectTableServiceImpl extends GlobalServiceImpl<ProjectTable> implements ProjectTableService{

    @Autowired
    private ProjectTableDao projectTableDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectTableVo> paginate(ProjectTableQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectTableVo> list = projectTableDao.paginate(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(ProjectTable entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectTable entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectTable save(ProjectTable entity) {
        return insertSelective(entity);
    }

}

