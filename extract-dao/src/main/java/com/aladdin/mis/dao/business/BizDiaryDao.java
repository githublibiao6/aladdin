package com.aladdin.mis.dao.business;

import com.aladdin.mis.business.qo.BizDiaryQo;
import com.aladdin.mis.business.vo.BizDiaryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BizDiaryDao
 * @author cles
 * @date 2024-09-01T20:50:27.841
*/
@Repository
public interface BizDiaryDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BizDiaryVo> list(BizDiaryQo qo);
}
