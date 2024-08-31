package com.aladdin.mis.business.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 收藏表
 * @author cles
 * @date 2024-08-31 21:53:31
*/
@Table("biz_post_thumb")
@Data
public class BizPostThumb extends GlobalModel {

    /**
     * postId帖子主键
     */
    @TableField("post_id")
    private Integer postId;

    /**
     * userId用户主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * collectTime点赞时间
     */
    @TableField("collect_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime collectTime;

}
