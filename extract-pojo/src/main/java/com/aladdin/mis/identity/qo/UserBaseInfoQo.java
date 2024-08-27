package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.UserBaseInfo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 查询实体 
 * @author cles
 * @date 2024-08-27 23:36:32
*/
@Data
public class UserBaseInfoQo extends UserBaseInfo {

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
