package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatGroupRecord;
import com.aladdin.mis.chat.qo.ChatGroupRecordQo;
import com.aladdin.mis.chat.vo.ChatGroupRecordVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatGroupRecordDao
 * @author cles
 * @date 2024-08-30T00:19:17.603
*/
@Repository
public interface ChatGroupRecordDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatGroupRecordVo> list(ChatGroupRecordQo qo);
}
