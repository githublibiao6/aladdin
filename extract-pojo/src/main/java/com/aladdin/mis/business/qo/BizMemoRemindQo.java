package com.aladdin.mis.business.qo;

import com.aladdin.mis.business.entity.BizMemoRemind;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 便签提醒设置表查询实体 
 * @author cles
 * @date 2024-09-01 22:26:11
*/
@Data
public class BizMemoRemindQo extends BizMemoRemind {

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
