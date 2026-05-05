package com.aladdin.mis.chat.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.chat.entity.ChatUserFriendApply;
import com.aladdin.mis.chat.param.ChatUserFriendApplyParam;
import com.aladdin.mis.chat.vo.ChatUserFriendApplyVo;
import com.aladdin.mis.chat.qo.ChatUserFriendApplyQo;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
/**
 * ChatUserFriendApplyService
 * @author cles
 * @date 2024-08-30 00:20:18
*/
public interface ChatUserFriendApplyService extends GlobalService<ChatUserFriendApply>  {

    /**
     * 好友申请
     * @param m
     * @return
     */
    Result create(ChatUserFriendApplyParam m);

    /**
     * 申请审核
     * @param m
     * @return
     */
    boolean edit(ChatUserFriendApply m);
}
