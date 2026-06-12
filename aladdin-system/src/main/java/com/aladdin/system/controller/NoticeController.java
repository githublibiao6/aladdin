package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysNotice;
import com.aladdin.system.service.SysNoticeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统通知公告控制器
 *
 * @author cles
 * @date 2026/06/12
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final SysNoticeService noticeService;

    public NoticeController(SysNoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /** 获取公告列表（管理端） */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:notice:list')")
    public R<List<SysNotice>> list() {
        return R.ok(noticeService.list());
    }

    /** 获取已发布公告（前端展示） */
    @GetMapping("/published")
    public R<List<SysNotice>> published() {
        return R.ok(noticeService.getPublishedNotices());
    }

    /** 获取公告详情 */
    @GetMapping("/detail/{id}")
    public R<SysNotice> getById(@PathVariable Long id) {
        return R.ok(noticeService.getById(id));
    }

    /** 新增公告 */
    @PostMapping
    @PreAuthorize("hasAuthority('system:notice:add')")
    public R<Void> save(@RequestBody SysNotice notice) {
        if (notice.getStatus() == null) {
            notice.setStatus(0);
        }
        return noticeService.save(notice) ? R.ok() : R.fail();
    }

    /** 修改公告 */
    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:notice:edit')")
    public R<Void> update(@RequestBody SysNotice notice) {
        return noticeService.updateById(notice) ? R.ok() : R.fail();
    }

    /** 删除公告 */
    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:notice:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return noticeService.removeById(id) ? R.ok() : R.fail();
    }

    /** 发布公告 */
    @PostMapping("/publish/{id}")
    @PreAuthorize("hasAuthority('system:notice:edit')")
    public R<Void> publish(@PathVariable Long id) {
        return noticeService.publish(id) ? R.ok() : R.fail();
    }

    /** 撤回公告 */
    @PostMapping("/revoke/{id}")
    @PreAuthorize("hasAuthority('system:notice:edit')")
    public R<Void> revoke(@PathVariable Long id) {
        return noticeService.revoke(id) ? R.ok() : R.fail();
    }
}
