package com.aladdin.mis.business.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 便签表
 * @author cles
 * @date 2024-09-15 23:15:57
*/
@Table("biz_memo")
@Data
public class BizMemo extends GlobalModel {

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
     * content便签内容
     */
    @TableField("content")
    private String content;

    /**
     * memoType便签类型 1 普通便签 2 代办事项 3 提醒 4 
     */
    @TableField("memo_type")
    private Integer memoType;

    /**
     * top是否置顶
     */
    @TableField("top")
    private Integer top;

    /**
     * done是否已办
     */
    @TableField("done")
    private Integer done;

    /**
     * remind是否提醒
     */
    @TableField("remind")
    private Integer remind;

    /**
     * remindType提醒类型
     */
    @TableField("remind_type")
    private Integer remindType;

    /**
     * importance重要性
     */
    @TableField("importance")
    private Integer importance;

    /**
     * nextRemindTime下一个提醒日期
     */
    @TableField("next_remind_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime nextRemindTime;

    /**
     * remindInfo提醒信息
     */
    @TableField("remind_info")
    private String remindInfo;

    /**
     * createTime写入时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
