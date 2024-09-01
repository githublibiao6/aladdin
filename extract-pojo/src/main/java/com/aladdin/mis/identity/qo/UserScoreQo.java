package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.UserScore;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 用户积分表查询实体 
 * @author cles
 * @date 2024-09-01 23:28:33
*/
@Data
public class UserScoreQo extends UserScore {

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
