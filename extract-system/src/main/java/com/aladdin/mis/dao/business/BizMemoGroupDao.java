package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.entity.BizMemoGroup;
import com.aladdin.mis.business.qo.BizMemoGroupQo;
import com.aladdin.mis.business.vo.BizMemoGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizMemoGroupDao
 * @author cles
 * @date 2024-09-01T22:25:36.020
*/
@Repository
public interface BizMemoGroupDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizMemoGroupVo> list(BizMemoGroupQo qo);
}
