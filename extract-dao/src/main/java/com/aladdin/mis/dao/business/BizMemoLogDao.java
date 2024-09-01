package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizMemoLog;
import com.aladdin.mis.business.qo.BizMemoLogQo;
import com.aladdin.mis.business.vo.BizMemoLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizMemoLogDao
 * @author cles
 * @date 2024-09-01T22:25:53.370
*/
@Repository
public interface BizMemoLogDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizMemoLogVo> list(BizMemoLogQo qo);
}
