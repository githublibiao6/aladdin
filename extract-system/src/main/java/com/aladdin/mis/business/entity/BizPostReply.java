package com.aladdin.mis.business.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 帖子回复表
 * @author cles
 * @date 2024-09-01 20:24:06
*/
@Table("biz_post_reply")
@Data
public class BizPostReply extends GlobalModel {

    /**
     * postId帖子主键
     */
    @TableField("post_id")
    private Integer postId;

    /**
     * replyId回复主键
     */
    @TableField("reply_id")
    private Integer replyId;

    /**
     * userId用户主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * userName用户名称（冗余）
     */
    @TableField("user_name")
    private String userName;

    /**
     * userPic用户头像
     */
    @TableField("user_pic")
    private String userPic;

    /**
     * toUserId回复人
     */
    @TableField("to_user_id")
    private Integer toUserId;

    /**
     * toUserName被回复人
     */
    @TableField("to_user_name")
    private String toUserName;

    /**
     * toUserPic被回复人头像
     */
    @TableField("to_user_pic")
    private String toUserPic;

    /**
     * content评论内容
     */
    @TableField("content")
    private String content;

    /**
     * parentId回复内容
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * thumbNum点赞数量
     */
    @TableField("thumb_num")
    private Integer thumbNum;

    /**
     * replyNum回复数量
     */
    @TableField("reply_num")
    private Integer replyNum;

    /**
     * replyTime回复时间
     */
    @TableField("reply_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime replyTime;

    /**
     * terminal终端名称
     */
    @TableField("terminal")
    private String terminal;

    /**
     * top是否置顶
     */
    @TableField("top")
    private Integer top;

    /**
     * first是否首评
     */
    @TableField("first")
    private Integer first;

}
