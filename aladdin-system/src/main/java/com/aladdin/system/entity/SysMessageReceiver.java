package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 站内信接收记录实体
 * readStatus: 0-未读 1-已读
 * handleStatus: 0-未处理 1-已处理 2-已忽略（仅待办类型）
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_message_receiver")
public class SysMessageReceiver extends BaseEntity {

    /** 消息ID */
    private Long messageId;
    /** 接收者ID */
    private Long receiverId;
    /** 阅读状态: 0未读 1已读 */
    private Integer readStatus;
    /** 阅读时间 */
    private LocalDateTime readTime;
    /** 处理状态: 0未处理 1已处理 2已忽略（仅待办类型） */
    private Integer handleStatus;
}
