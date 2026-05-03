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
 * 点赞表
 * @author cles
 * @date 2024-08-31 21:53:08
*/
@Table("biz_post_collect")
@Data
public class BizPostCollect extends GlobalModel {

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
     * thumbTime点赞时间
     */
    @TableField("thumb_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thumbTime;

}
