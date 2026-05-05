package com.aladdin.mis.identity.qo;

import com.aladdin.mis.identity.entity.Admin;
import lombok.Data;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class AdminQo extends Admin {

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer limit;

    /**
     * 组织机构主键
     */
    private Integer deptId;

}
