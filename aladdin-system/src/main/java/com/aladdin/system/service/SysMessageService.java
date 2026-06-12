package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysMessage;
import com.aladdin.system.entity.SysMessageReceiver;

import java.util.List;

/**
 * 站内信服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysMessageService extends BaseService<SysMessage> {

    /** 发送单条消息 */
    void sendSingle(Long senderId, Long receiverId, String title, String content, Integer msgType);

    /** 群发消息 */
    void sendBatch(Long senderId, List<Long> receiverIds, String title, String content, Integer msgType);

    /** 获取用户消息列表 */
    List<SysMessageReceiver> getUserMessages(Long userId);

    /** 获取未读消息数 */
    int getUnreadCount(Long userId);

    /** 标记已读 */
    boolean markAsRead(Long messageId, Long userId);

    /** 全部标记已读 */
    boolean markAllAsRead(Long userId);

    /** 处理待办 */
    boolean handleTodo(Long messageId, Long userId, Integer handleStatus);
}
