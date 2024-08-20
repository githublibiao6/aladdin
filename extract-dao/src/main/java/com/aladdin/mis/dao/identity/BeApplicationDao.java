package com.aladdin.mis.dao.identity;

import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeApplicationDao
 * @author cles
 * @date 2024-08-21T03:21:11.562
*/
@Repository
public interface BeApplicationDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeApplicationVo> list(BeApplicationQo qo);
}
