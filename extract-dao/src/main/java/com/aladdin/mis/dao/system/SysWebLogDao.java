package com.aladdin.mis.dao.system;

import com.aladdin.mis.system.entity.SysWebLog;
import com.aladdin.mis.system.qo.SysWebLogQo;
import com.aladdin.mis.system.vo.SysWebLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * SysWebLogService
 * @author cles
 * @date 2021-09-01T00:35:30.806
*/
@Repository
public interface SysWebLogDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<SysWebLogVo> paginate(SysWebLogQo qo);}
