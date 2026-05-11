package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.UserProperty;
import lombok.Data;

/**
 * 用户资产表查询实："
 * @author cles
 * @date 2024-09-01 23:28:25
*/
@Data
public class UserPropertyQo extends UserProperty {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过："
     */
    private String  keyWord;
    /**
     * 排序条件
     */
    private String  sortInfo;
}
