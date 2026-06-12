package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysMessageReceiver;
import com.aladdin.system.service.SysMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 站内信控制器
 *
 * @author cles
 * @date 2026/06/12
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final SysMessageService messageService;

    public MessageController(SysMessageService messageService) {
        this.messageService = messageService;
    }

    /** 发送单条消息 */
    @PostMapping("/send")
    public R<Void> sendSingle(@RequestBody Map<String, Object> body) {
        Long senderId = LoginService.getCurrentUserId();
        Long receiverId = Long.valueOf(body.get("receiverId").toString());
        String title = (String) body.get("title");
        String content = (String) body.get("content");
        Integer msgType = Integer.valueOf(body.getOrDefault("msgType", "1").toString());
        messageService.sendSingle(senderId, receiverId, title, content, msgType);
        return R.ok();
    }

    /** 群发消息 */
    @PostMapping("/sendBatch")
    public R<Void> sendBatch(@RequestBody Map<String, Object> body) {
        Long senderId = LoginService.getCurrentUserId();
        @SuppressWarnings("unchecked")
        List<Long> receiverIds = (List<Long>) body.get("receiverIds");
        String title = (String) body.get("title");
        String content = (String) body.get("content");
        Integer msgType = Integer.valueOf(body.getOrDefault("msgType", "1").toString());
        messageService.sendBatch(senderId, receiverIds, title, content, msgType);
        return R.ok();
    }

    /** 获取我的消息列表 */
    @GetMapping("/list")
    public R<List<SysMessageReceiver>> list() {
        Long userId = LoginService.getCurrentUserId();
        return R.ok(messageService.getUserMessages(userId));
    }

    /** 获取未读消息数 */
    @GetMapping("/unreadCount")
    public R<Integer> unreadCount() {
        Long userId = LoginService.getCurrentUserId();
        return R.ok(messageService.getUnreadCount(userId));
    }

    /** 标记已读 */
    @PostMapping("/read/{messageId}")
    public R<Void> markAsRead(@PathVariable Long messageId) {
        Long userId = LoginService.getCurrentUserId();
        return messageService.markAsRead(messageId, userId) ? R.ok() : R.fail();
    }

    /** 全部标记已读 */
    @PostMapping("/readAll")
    public R<Void> markAllAsRead() {
        Long userId = LoginService.getCurrentUserId();
        return messageService.markAllAsRead(userId) ? R.ok() : R.fail();
    }

    /** 处理待办 */
    @PostMapping("/handle/{messageId}")
    public R<Void> handleTodo(@PathVariable Long messageId, @RequestBody Map<String, Integer> body) {
        Long userId = LoginService.getCurrentUserId();
        Integer handleStatus = body.get("handleStatus");
        return messageService.handleTodo(messageId, userId, handleStatus) ? R.ok() : R.fail();
    }
}
