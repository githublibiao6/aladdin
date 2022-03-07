package com.aladdin.mis.system.qo;

import com.aladdin.mis.system.entity.BeLoginLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 查询实体 
 * @author cles
 * @date 2022-02-24T23:38:47.807
*/
@Data
public class BeLoginLogQo extends BeLoginLog {

    private Integer page;
    private Integer limit;
}
