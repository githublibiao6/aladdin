package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysNotice;

import java.util.List;

/**
 * 系统通知公告服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysNoticeService extends BaseService<SysNotice> {

    /** 发布公告 */
    boolean publish(Long noticeId);

    /** 撤回公告 */
    boolean revoke(Long noticeId);

    /** 获取已发布的公告列表 */
    List<SysNotice> getPublishedNotices();
}
