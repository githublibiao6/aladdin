package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 站内信实体
 * msgType: 1-系统通知 2-私信 3-待办 4-提醒
 * sendType: 1-单发 2-群发
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_message")
public class SysMessage extends BaseEntity {

    /** 消息标题 */
    private String title;
    /** 消息内容 */
    private String content;
    /** 消息类型: 1系统通知 2私信 3待办 4提醒 */
    private Integer msgType;
    /** 发送类型: 1单发 2群发 */
    private Integer sendType;
    /** 发送者ID，0表示系统 */
    private Long senderId;
    /** 租户ID */
    private Long tenantId;
}
