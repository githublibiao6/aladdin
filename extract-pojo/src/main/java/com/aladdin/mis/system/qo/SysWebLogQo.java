package com.aladdin.mis.mapper.qo;

import com.aladdin.mis.mapper.entity.SysWebLog;
import lombok.Data;

/**
 * 请求日志查询实体
 * @author cles
 * @date 2021-09-01T00:35:30.803
*/
@Data
public class SysWebLogQo extends SysWebLog {

    private Integer page;

    private Integer limit;

}
