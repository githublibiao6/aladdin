package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 系统通知公告实体
 * noticeType: 1-通知 2-公告
 * status: 0-草稿 1-已发布 2-已撤回
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_notice")
public class SysNotice extends BaseEntity {

    /** 公告标题 */
    private String title;
    /** 公告内容 */
    private String content;
    /** 公告类型: 1通知 2公告 */
    private Integer noticeType;
    /** 状态: 0草稿 1已发布 2已撤回 */
    private Integer status;
    /** 发布时间 */
    private LocalDateTime publishTime;
    /** 租户ID */
    private Long tenantId;
}
