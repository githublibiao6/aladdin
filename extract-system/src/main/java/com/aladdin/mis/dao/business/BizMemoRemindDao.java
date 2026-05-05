package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizMemoRemind;
import com.aladdin.mis.business.qo.BizMemoRemindQo;
import com.aladdin.mis.business.vo.BizMemoRemindVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizMemoRemindDao
 * @author cles
 * @date 2024-09-01T22:26:11.199
*/
@Repository
public interface BizMemoRemindDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizMemoRemindVo> list(BizMemoRemindQo qo);
}
