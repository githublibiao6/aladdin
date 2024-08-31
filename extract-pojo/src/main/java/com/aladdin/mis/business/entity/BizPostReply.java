package com.aladdin.mis.business.entity;

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
 * 帖子回复表
 * @author cles
 * @date 2024-08-31 21:52:48
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
     * backUserId回复人
     */
    @TableField("back_user_id")
    private Integer backUserId;

    /**
     * backUserName被回复人
     */
    @TableField("back_user_name")
    private String backUserName;

    /**
     * backUserPic被回复人头像
     */
    @TableField("back_user_pic")
    private String backUserPic;

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

}
