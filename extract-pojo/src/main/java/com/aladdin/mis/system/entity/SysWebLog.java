package com.aladdin.mis.system.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 请求日志
 * @author cles
 * @date 2021-09-01T00:35:30.799
*/
@Table("sys_web_log")
@Data
public class SysWebLog extends GlobalModel {
    /**
    * postNum请求编号
    */
    @TableField("post_num")
    private String postNum;

    /**
    * ip请求ip
    */
    @TableField("ip")
    private String ip;

    /**
    * url请求地址
    */
    @TableField("url")
    private String url;

    /**
    * url请求地址
    */
    @TableField("method")
    private String method;

    /**
    * requestParam参数
    */
    @TableField("request_param")
    private String requestParam;

    /**
    * response返回数据
    */
    @TableField("response")
    private String response;

    /**
    * userId请求人
    */
    @TableField("user_id")
    private Integer userId;

    /**
    * status请求状态
    */
    @TableField("status")
    private String status;

    /**
    * cost耗时
    */
    @TableField("cost")
    private Integer cost;

    /**
    * startTime开始时间
    */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
    * endTime结束时间
    */
    @TableField("end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
