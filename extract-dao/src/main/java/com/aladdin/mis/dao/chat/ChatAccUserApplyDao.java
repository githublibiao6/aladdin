package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatAccUserApply;
import com.aladdin.mis.chat.qo.ChatAccUserApplyQo;
import com.aladdin.mis.chat.vo.ChatAccUserApplyVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatAccUserApplyDao
 * @author cles
 * @date 2024-09-02T00:11:31.660
*/
@Repository
public interface ChatAccUserApplyDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatAccUserApplyVo> list(ChatAccUserApplyQo qo);
}
