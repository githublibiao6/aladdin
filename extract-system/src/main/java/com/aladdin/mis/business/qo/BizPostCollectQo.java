package com.aladdin.mis.business.qo;

import com.aladdin.mis.business.entity.BizPostCollect;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 点赞表查询实体 
 * @author cles
 * @date 2024-08-31 21:53:08
*/
@Data
public class BizPostCollectQo extends BizPostCollect {

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
