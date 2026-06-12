package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysMessageReceiver;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 站内信接收记录DAO
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysMessageReceiverDao extends BaseDao<SysMessageReceiver> {

    @Select("SELECT mr.*, m.title, m.content, m.msg_type, m.send_type, m.sender_id " +
            "FROM sys_message_receiver mr " +
            "LEFT JOIN sys_message m ON mr.message_id = m.id " +
            "WHERE mr.receiver_id = #{userId} AND mr.sys005 = 1 " +
            "ORDER BY mr.sys001 DESC")
    List<SysMessageReceiver> selectByReceiverId(@Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM sys_message_receiver " +
            "WHERE receiver_id = #{userId} AND read_status = 0 AND sys005 = 1")
    int countUnread(@Param("userId") Long userId);

    @Update("UPDATE sys_message_receiver SET read_status = 1, read_time = NOW() " +
            "WHERE message_id = #{messageId} AND receiver_id = #{userId}")
    int markAsRead(@Param("messageId") Long messageId, @Param("userId") Long userId);

    @Update("UPDATE sys_message_receiver SET read_status = 1, read_time = NOW() " +
            "WHERE receiver_id = #{userId} AND read_status = 0")
    int markAllAsRead(@Param("userId") Long userId);

    @Update("UPDATE sys_message_receiver SET handle_status = #{handleStatus} " +
            "WHERE message_id = #{messageId} AND receiver_id = #{userId}")
    int updateHandleStatus(@Param("messageId") Long messageId, @Param("userId") Long userId, @Param("handleStatus") Integer handleStatus);
}
