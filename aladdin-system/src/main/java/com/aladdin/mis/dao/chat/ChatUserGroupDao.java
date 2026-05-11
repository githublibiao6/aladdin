package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatUserGroup;
import com.aladdin.mis.chat.qo.ChatUserGroupQo;
import com.aladdin.mis.chat.vo.ChatUserGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatUserGroupDao
 * @author cles
 * @date 2024-08-30T00:20:29.036
*/
@Repository
public interface ChatUserGroupDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatUserGroupVo> list(ChatUserGroupQo qo);
}
