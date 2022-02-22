package com.aladdin.mis.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 实体执行日志
 * @author cles
 * @date 2022-02-22T00:35:30.799
*/
@Data
public class SqlLog {

    /**
    * 请求人名称
    */
    private String requestUserName;

    /**
     * 执行类型
     */
    private String sqlType;

    /**
     * 执行语句
     */

    private String sql;

    /**
     * 表名
     */

    private String tableName;

    /**
     * 表主键
     */

    private String tableId;

    /**
     * 开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime endTime;

    /**
     * 执行耗时
     */
    private Long cost;

    /**
     * 执行状态
     */
    private int code;



}
