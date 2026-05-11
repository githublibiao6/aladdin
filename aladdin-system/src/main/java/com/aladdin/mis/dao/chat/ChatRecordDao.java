package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatRecord;
import com.aladdin.mis.chat.qo.ChatRecordQo;
import com.aladdin.mis.chat.vo.ChatRecordVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatRecordDao
 * @author cles
 * @date 2024-07-09T00:35:53.250
*/
@Repository
public interface ChatRecordDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatRecordVo> list(ChatRecordQo qo);
}
