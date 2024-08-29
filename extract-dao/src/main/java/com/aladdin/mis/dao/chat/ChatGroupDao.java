package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatGroup;
import com.aladdin.mis.chat.qo.ChatGroupQo;
import com.aladdin.mis.chat.vo.ChatGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatGroupDao
 * @author cles
 * @date 2024-08-30T00:19:09.056
*/
@Repository
public interface ChatGroupDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatGroupVo> list(ChatGroupQo qo);
}
