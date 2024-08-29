package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatList;
import com.aladdin.mis.chat.qo.ChatListQo;
import com.aladdin.mis.chat.vo.ChatListVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatListDao
 * @author cles
 * @date 2024-08-30T00:19:46.685
*/
@Repository
public interface ChatListDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatListVo> list(ChatListQo qo);
}
