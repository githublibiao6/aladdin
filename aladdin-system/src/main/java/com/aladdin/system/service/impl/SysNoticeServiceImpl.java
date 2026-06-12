package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysNoticeDao;
import com.aladdin.system.entity.SysNotice;
import com.aladdin.system.service.SysNoticeService;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.aladdin.system.entity.table.SysNoticeTableDef.SYS_NOTICE;

/**
 * 系统通知公告服务实现
 *
 * @author cles
 * @date 2026/06/12
 */
@Service
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNoticeDao, SysNotice> implements SysNoticeService {

    @Override
    public boolean publish(Long noticeId) {
        SysNotice notice = getById(noticeId);
        if (notice == null) {
            return false;
        }
        notice.setStatus(1);
        notice.setPublishTime(LocalDateTime.now());
        return updateById(notice);
    }

    @Override
    public boolean revoke(Long noticeId) {
        SysNotice notice = getById(noticeId);
        if (notice == null) {
            return false;
        }
        notice.setStatus(2);
        return updateById(notice);
    }

    @Override
    public List<SysNotice> getPublishedNotices() {
        return list(QueryWrapper.create()
                .where(SYS_NOTICE.STATUS.eq(1))
                .and(SYS_NOTICE.SYS005.eq(1))
                .orderBy(SYS_NOTICE.PUBLISH_TIME.desc()));
    }
}
