package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.vo.ProjectTableFieldVo;
import com.aladdin.mis.engineering.qo.ProjectTableFieldQo;
import com.aladdin.mis.dao.engineering.ProjectTableFieldDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@Service
public class ProjectTableFieldServiceImpl extends GlobalServiceImpl<ProjectTableField> implements ProjectTableFieldService{

    @Autowired
    private ProjectTableFieldDao projectTableFieldDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<ProjectTableFieldVo> paginate(ProjectTableFieldQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<ProjectTableFieldVo> list = projectTableFieldDao.paginate(qo);
       return new PageInfo<>(list);
}
    @Override
    public boolean remove(ProjectTableField entity) {
        return delete(entity);
    }

    @Override
    public boolean update(ProjectTableField entity) {
        return updateSelective(entity);
    }

    @Override
    public ProjectTableField save(ProjectTableField entity) {
        return insertSelective(entity);
    }

}

