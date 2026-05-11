package com.aladdin.mis.dao.identity;

import com.aladdin.mis.identity.entity.BeAdminApplication;
import com.aladdin.mis.identity.qo.BeAdminApplicationQo;
import com.aladdin.mis.identity.vo.BeAdminApplicationVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeAdminApplicationDao
 * @author cles
 * @date 2024-08-21T03:38:11.125
*/
@Repository
public interface BeAdminApplicationDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeAdminApplicationVo> list(BeAdminApplicationQo qo);
}
