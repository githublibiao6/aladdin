package com.aladdin.common.db.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * SQL执行日志
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class SqlLog {

    private String sessionId;

    private String requestUserName;

    private String sqlType;

    private String executeSql;

    private String tableName;

    private int tableId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    private Long cost;

    private int code;

    private String errorMsg;
}
