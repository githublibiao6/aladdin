package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizPostCollect;
import com.aladdin.mis.business.qo.BizPostCollectQo;
import com.aladdin.mis.business.vo.BizPostCollectVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizPostCollectDao
 * @author cles
 * @date 2024-08-31T21:53:08.585
*/
@Repository
public interface BizPostCollectDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizPostCollectVo> list(BizPostCollectQo qo);
}
