package com.aladdin.mis.manager.qo;

import com.aladdin.mis.manager.bean.User;
import lombok.Data;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class UserQo extends User {

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer limit;

    /**
     * 每页数量
     */
    private String keyWord;

    /**
     * 用户状态
     */
    private String status;

}
