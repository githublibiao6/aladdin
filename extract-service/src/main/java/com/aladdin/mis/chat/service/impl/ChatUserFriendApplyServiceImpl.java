package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.param.ChatUserFriendApplyParam;
import com.aladdin.mis.chat.service.ChatUserFriendApplyService;
import com.aladdin.mis.chat.entity.ChatUserFriendApply;
import com.aladdin.mis.chat.vo.ChatUserFriendApplyVo;
import com.aladdin.mis.chat.qo.ChatUserFriendApplyQo;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.dao.chat.ChatUserFriendApplyDao;
import com.aladdin.mis.identity.service.UserService;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.system.user.vo.OmUser;
import com.aladdin.mis.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatUserFriendApplyService
 * @author cles
 * @date 2024-08-30 00:20:18
*/
@Service
public class ChatUserFriendApplyServiceImpl extends GlobalServiceImpl<ChatUserFriendApply> implements ChatUserFriendApplyService{

    @Autowired
    private UserService userService;

    @Autowired
    private ChatUserFriendApplyDao chatUserFriendApplyDao;

    @Override
    public Result create(ChatUserFriendApplyParam param) {
        Result result = new Result();
        User user = userService.getByUserNumber(param.getFriendNumber());
        if(user == null){
            result.setMessage("申请失败，好友不存在");
            result.setSuccess(false);
            return result;
        }
        ChatUserFriendApply m = new ChatUserFriendApply();
        OmUser om = UserUtil.getCurrentUser();
        m.setUserId(om.getUserId());
        m.setApplyStatus(1);
        m.setApplyTime(LocalDateTime.now());
        Integer id = insert(m);
        if(id != null){
           result.setMessage("申请成功");
        }else {
           result.setMessage("申请失败");
           result.setSuccess(false);
        }
        return result;
    }

    @Override
    public boolean edit(ChatUserFriendApply m) {
        m.setAuditTime(LocalDateTime.now());
        // 用户添加 类似账号
        return updateSelective(m);
    }
}

