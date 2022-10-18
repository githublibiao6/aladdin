package com.aladdin.mis.system.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.qo.BeLoginLogQo;
import com.aladdin.mis.system.vo.BeLoginLogVo;
import com.github.pagehelper.PageInfo;

/**
 * BeLoginLogService
 * @author cles
 * @date 2022-02-24T22:09:10.287
*/
public interface BeLoginLogService extends GlobalService<BeLoginLog>  {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<BeLoginLogVo> paginate(BeLoginLogQo qo);

    /**
     * 查询详情
     * @param qo
     * @return entity
     */
    BeLoginLog detail(BeLoginLog qo);

    /**
     * 删除
     * @param entity
     * @return flag
     */
    boolean remove(BeLoginLog entity);

    /**
     * 更新
     * @param entity
     * @return flag
     */
    boolean update(BeLoginLog entity);

    /**
     * 保存
     * @param entity
     * @return m
     */
    BeLoginLog save(BeLoginLog entity);

    /**
     * 保存登录日志
     */
    void saveLoginLog(BeLoginLog entity);
}
