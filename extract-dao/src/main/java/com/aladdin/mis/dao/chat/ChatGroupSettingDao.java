package com.aladdin.mis.dao.chat;

import com.aladdin.mis.chat.entity.ChatGroupSetting;
import com.aladdin.mis.chat.qo.ChatGroupSettingQo;
import com.aladdin.mis.chat.vo.ChatGroupSettingVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ChatGroupSettingDao
 * @author cles
 * @date 2024-08-30T00:21:21.175
*/
@Repository
public interface ChatGroupSettingDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ChatGroupSettingVo> list(ChatGroupSettingQo qo);
}
