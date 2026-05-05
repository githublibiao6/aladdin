package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.BeApplication;
import lombok.Data;

/**
 * 应用表查询实体
 * @author cles
 * @date 2024-08-21 03:21:11
*/
@Data
public class BeApplicationQo extends BeApplication {

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
