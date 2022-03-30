package com.aladdin.mis.base.qo;
/*
 *  Created by cles on 2022/3/28 23:25
 */

import lombok.Data;

import java.util.List;

/**
 * @author cles
 * @description: 基础查询类
 * @Date 2022/3/28 23:25
 * @version: 1.0.0
 */
@Data
public class QueryCondition {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 数量
     */
    private Integer limit;

    /**
     * 查询字段
     */
    private List<String> columns;

}
