package com.aladdin.mis.engineering.service;

import com.aladdin.mis.engineering.qo.GenerateQo;
import com.aladdin.mis.engineering.vo.GenerateVo;

import java.util.List;

/**
 * GenerateService
 * @author cles
 * @date 2021-08-31T22:26:17.068
*/
public interface GenerateService  {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    List<GenerateVo> listInfo(GenerateQo qo);

}
