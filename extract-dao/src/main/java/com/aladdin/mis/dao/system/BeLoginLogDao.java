package com.aladdin.mis.dao.system;

import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.qo.BeLoginLogQo;
import com.aladdin.mis.system.vo.BeLoginLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeLoginLogDao
 * @author cles
 * @date 2022-02-24T22:09:10.284
*/
@Repository
public interface BeLoginLogDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeLoginLogVo> list(BeLoginLogQo qo);}
