package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 朋友分组
 * @author cles
 * @date 2024-09-02 22:01:41
*/
@Table("chat_user_friend_group")
@Data
public class ChatUserFriendGroup extends GlobalModel {

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * groupName组备注
     */
    @TableField("group_name")
    private String groupName;

    /**
     * orderNum组排序
     */
    @TableField("order_num")
    private Integer orderNum;

}
