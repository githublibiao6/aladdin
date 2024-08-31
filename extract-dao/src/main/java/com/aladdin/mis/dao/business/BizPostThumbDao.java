package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizPostThumb;
import com.aladdin.mis.business.qo.BizPostThumbQo;
import com.aladdin.mis.business.vo.BizPostThumbVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizPostThumbDao
 * @author cles
 * @date 2024-08-31T21:53:31.877
*/
@Repository
public interface BizPostThumbDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizPostThumbVo> list(BizPostThumbQo qo);
}
