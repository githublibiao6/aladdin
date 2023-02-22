package com.aladdin.mis.system.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.system.entity.SysWebLog;
import com.aladdin.mis.system.qo.SysWebLogQo;
import com.aladdin.mis.system.vo.SysWebLogVo;
import com.github.pagehelper.PageInfo;

/**
 * SysWebLogService
 * @author cles
 * @date 2021-09-01T00:35:30.807
*/
public interface SysWebLogService extends GlobalService<SysWebLog>  {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<SysWebLogVo> paginate(SysWebLogQo qo);

    /**
     * 查询详情
     * @param qo
     * @return entity
     */
    SysWebLog detail(SysWebLog qo);

    /**
     * 删除请求日志
     * @param entity
     * @return flag
     */
    boolean remove(SysWebLog entity);

    /**
     * 更新请求日志
     * @param entity
     * @return flag
     */
    boolean update(SysWebLog entity);

    /**
     * 保存请求日志
     * @param entity
     * @return m
     */
    SysWebLog save(SysWebLog entity);

}
