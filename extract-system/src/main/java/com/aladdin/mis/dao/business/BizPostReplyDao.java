package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizPostReply;
import com.aladdin.mis.business.qo.BizPostReplyQo;
import com.aladdin.mis.business.vo.BizPostReplyVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizPostReplyDao
 * @author cles
 * @date 2024-08-31T21:52:48.548
*/
@Repository
public interface BizPostReplyDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizPostReplyVo> list(BizPostReplyQo qo);
}
