package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatGroupUser;
import com.aladdin.mis.chat.qo.ChatGroupUserQo;
import com.aladdin.mis.chat.vo.ChatGroupUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatGroupUserDao
 * @author cles
 * @date 2024-08-30T00:19:29.443
*/
@Repository
public interface ChatGroupUserDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatGroupUserVo> list(ChatGroupUserQo qo);
}
