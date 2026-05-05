package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.User;
import lombok.Data;

/**
 * 查询实体
 * @author cles
 * @date 2024-08-27 23:28:22
*/
@Data
public class UserQo extends User {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过滤
     */
    private String  keyWord;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 排序条件
     */
    private String  sortInfo;

}
