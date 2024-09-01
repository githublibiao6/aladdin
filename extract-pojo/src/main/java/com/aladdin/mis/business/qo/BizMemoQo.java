package com.aladdin.mis.business.qo;

import com.aladdin.mis.business.entity.BizMemo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 日记表查询实体 
 * @author cles
 * @date 2024-09-01 22:25:16
*/
@Data
public class BizMemoQo extends BizMemo {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过滤 
     */
    private String  keyWord;
    /**
     * 排序条件 
     */
    private String  sortInfo;
}
