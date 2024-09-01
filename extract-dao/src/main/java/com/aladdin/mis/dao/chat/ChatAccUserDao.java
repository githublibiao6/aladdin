package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatAccUser;
import com.aladdin.mis.chat.qo.ChatAccUserQo;
import com.aladdin.mis.chat.vo.ChatAccUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatAccUserDao
 * @author cles
 * @date 2024-09-02T00:11:21.287
*/
@Repository
public interface ChatAccUserDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatAccUserVo> list(ChatAccUserQo qo);
}
