package com.aladdin.mis.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 请求日志
 * @author cles
 * @date 2022-02-22T00:35:30.799
*/
@Data
public class VisitLog {

    /**
     * 请求人session
     */
    private String sessionId;

    /**
     * 请求识别符
     */
    private String requestId;

    /**
    * 请求路径
    */
    private String requestUrl;

    /**
     * 请求方法名称
     */
    private String methodName;

    /**
    * 请求人名称
    */
    private String requestUserName;

    /**
     * 请求ip
     */
    private String requestIp;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回数据
     */
    private String responseData;

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
     * 结束时间
     */
    private Long cost;

    /**
     * 请求状态
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;



}
