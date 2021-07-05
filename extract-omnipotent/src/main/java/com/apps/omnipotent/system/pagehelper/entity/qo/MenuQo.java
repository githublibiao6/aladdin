package com.apps.omnipotent.system.pagehelper.entity.qo;

import lombok.Data;

/**
 *  分页实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class MenuQo {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页数量
     */
    private int limit;

}
