package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatGroupUserApply;
import com.aladdin.mis.chat.qo.ChatGroupUserApplyQo;
import com.aladdin.mis.chat.vo.ChatGroupUserApplyVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatGroupUserApplyDao
 * @author cles
 * @date 2024-08-30T00:19:39.804
*/
@Repository
public interface ChatGroupUserApplyDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatGroupUserApplyVo> list(ChatGroupUserApplyQo qo);
}
