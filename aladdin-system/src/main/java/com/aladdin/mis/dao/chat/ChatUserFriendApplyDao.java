package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatUserFriendApply;
import com.aladdin.mis.chat.qo.ChatUserFriendApplyQo;
import com.aladdin.mis.chat.vo.ChatUserFriendApplyVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatUserFriendApplyDao
 * @author cles
 * @date 2024-08-30T00:20:18.770
*/
@Repository
public interface ChatUserFriendApplyDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatUserFriendApplyVo> list(ChatUserFriendApplyQo qo);
}
