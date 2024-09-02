package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.qo.ChatUserFriendGroupQo;
import com.aladdin.mis.chat.vo.ChatUserFriendGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatUserFriendGroupDao
 * @author cles
 * @date 2024-09-02T22:01:41.792
*/
@Repository
public interface ChatUserFriendGroupDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatUserFriendGroupVo> list(ChatUserFriendGroupQo qo);
}
