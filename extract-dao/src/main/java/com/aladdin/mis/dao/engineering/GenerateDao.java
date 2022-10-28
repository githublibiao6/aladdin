package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.GenerateQo;
import com.aladdin.mis.engineering.vo.GenerateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GenerateDao
 * @author cles
 * @date 2021-08-26T23:02:39.364
*/
@Repository
public interface GenerateDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<GenerateVo> listTable(GenerateQo qo);
}
