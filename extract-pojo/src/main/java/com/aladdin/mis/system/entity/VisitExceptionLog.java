package com.aladdin.mis.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 请求异常日志
 * @author cles
 * @date 2022-02-22T00:35:30.799
*/
@Data
public class VisitExceptionLog {

    /**
    * 异常标题
    */
    private String title;

    /**
     * 异常内容
     */
    private String exception;
    /**
     * 异常详情
     */
    private String exceptionDetail;

    /**
    * 异常代码
    */
    private int code;

    /**
    * 异常发生时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

}
