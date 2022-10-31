package com.aladdin.mis.system.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.system.service.SysWebLogService;
import com.aladdin.mis.system.entity.SysWebLog;
import com.aladdin.mis.system.vo.SysWebLogVo;
import com.aladdin.mis.system.qo.SysWebLogQo;
import com.aladdin.mis.dao.system.SysWebLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * SysWebLogService
 * @author cles
 * @date 2021-09-01T00:35:30.811
*/
@Service
public class SysWebLogServiceImpl extends GlobalServiceImpl<SysWebLog> implements SysWebLogService{

    @Autowired
    private SysWebLogDao sysWebLogDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<SysWebLogVo> paginate(SysWebLogQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<SysWebLogVo> list = sysWebLogDao.paginate(qo);
       return new PageInfo<>(list);
}
    /**
     * 查询详情
     * @param qo
     * @return
     */
    @Override
    public SysWebLog detail(SysWebLog qo){
       return detailQuery(qo.getId());
}

    @Override
    public boolean remove(SysWebLog entity) {
        return delete(entity);
    }

    @Override
    public boolean update(SysWebLog entity) {
        return updateSelective(entity);
    }

    @Override
    public SysWebLog save(SysWebLog entity) {
        return insertSelective(entity);
    }

}

