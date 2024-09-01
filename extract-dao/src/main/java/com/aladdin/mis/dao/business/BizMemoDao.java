package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizMemo;
import com.aladdin.mis.business.qo.BizMemoQo;
import com.aladdin.mis.business.vo.BizMemoVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizMemoDao
 * @author cles
 * @date 2024-09-01T22:25:16.135
*/
@Repository
public interface BizMemoDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizMemoVo> list(BizMemoQo qo);
}
