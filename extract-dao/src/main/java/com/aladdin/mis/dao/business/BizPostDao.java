package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizPost;
import com.aladdin.mis.business.qo.BizPostQo;
import com.aladdin.mis.business.vo.BizPostVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizPostDao
 * @author cles
 * @date 2024-08-31T21:50:30.140
*/
@Repository
public interface BizPostDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizPostVo> list(BizPostQo qo);
}
