package com.aladdin.mis.common.system.qo;

import lombok.Data;

/**
 * 查询实体
 * @author cles
 * @date 2022-02-24T23:38:47.807
*/
@Data
public class BeLoginLogQo  {

    // todo extends BeLoginLog

    private Integer page;

    private Integer limit;
}