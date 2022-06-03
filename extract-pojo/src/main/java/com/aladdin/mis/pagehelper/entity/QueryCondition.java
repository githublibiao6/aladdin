package com.aladdin.mis.pagehelper.entity;

import lombok.Data;

import java.util.Date;

/**
 *  通用查询条件   bean
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class QueryCondition {

    private String id;
    /**
     * 关键字
     */
    private String keyWord;
    /**
     * 性别
     */
    private String sex;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 标志
     */
    private String flag;
}
