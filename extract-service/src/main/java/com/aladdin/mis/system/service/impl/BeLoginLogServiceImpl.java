package com.aladdin.mis.system.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.system.service.BeLoginLogService;
import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.vo.BeLoginLogVo;
import com.aladdin.mis.system.qo.BeLoginLogQo;
import com.aladdin.mis.dao.system.BeLoginLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * BeLoginLogService
 * @author cles
 * @date 2022-02-24T22:09:10.288
*/
@Service
public class BeLoginLogServiceImpl extends GlobalServiceImpl<BeLoginLog> implements BeLoginLogService{

    @Autowired
    private BeLoginLogDao beLoginLogDao;

    /**
     * 分页查询
     * @param qo
     * @return
     */
   @Override
    public PageInfo<BeLoginLogVo> paginate(BeLoginLogQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<BeLoginLogVo> list = beLoginLogDao.list(qo);
       return new PageInfo<>(list);
}
    /**
     * 查询详情
     * @param qo
     * @return
     */
   @Override
    public BeLoginLog detail(BeLoginLog qo){
       return detailQuery(qo.getId());
}
    @Override
    public boolean remove(BeLoginLog entity) {
       return delete(entity);
    }

    @Override
    public boolean update(BeLoginLog entity) {
       return updateSelective(entity);
    }

    @Override
    public BeLoginLog save(BeLoginLog entity) {
       return insertSelective(entity);
    }

}

