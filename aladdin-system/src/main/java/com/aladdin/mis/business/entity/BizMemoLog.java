package com.aladdin.mis.business.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 便签日志："
 * @author cles
 * @date 2024-09-15 23:15:52
*/
@Table("biz_memo_log")
@Data
public class BizMemoLog extends GlobalModel {

    /**
     * userId用户主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * groupId
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * groupName
     */
    @TableField("group_name")
    private String groupName;

    /**
     * memoId便签id
     */
    @TableField("memo_id")
    private Integer memoId;

    /**
     * content日记内容
     */
    @TableField("content")
    private String content;

    /**
     * logType便签类型 1 普通便："2 代办事项 3 提醒 4 
     */
    @TableField("log_type")
    private Integer logType;

    /**
     * createTime写入时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
