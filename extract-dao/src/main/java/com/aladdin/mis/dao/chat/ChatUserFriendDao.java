package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatUserFriend;
import com.aladdin.mis.chat.qo.ChatUserFriendQo;
import com.aladdin.mis.chat.vo.ChatUserFriendVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatUserFriendDao
 * @author cles
 * @date 2024-08-30T00:20:11.684
*/
@Repository
public interface ChatUserFriendDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatUserFriendVo> list(ChatUserFriendQo qo);
}
