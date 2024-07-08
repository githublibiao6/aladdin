package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatSession;
import com.aladdin.mis.chat.qo.ChatSessionQo;
import com.aladdin.mis.chat.vo.ChatSessionVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatSessionDao
 * @author cles
 * @date 2024-07-09T00:35:45.600
*/
@Repository
public interface ChatSessionDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatSessionVo> list(ChatSessionQo qo);
}
