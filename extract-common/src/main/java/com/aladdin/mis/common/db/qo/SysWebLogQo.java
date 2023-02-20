package com.aladdin.mis.common.db.qo;

import lombok.Data;

/**
 * 请求日志查询实体
 * @author cles
 * @date 2021-09-01T00:35:30.803
*/
@Data
public class SysWebLogQo  {

    // todo extends SysWebLog

    private Integer page;

    private Integer limit;

}
