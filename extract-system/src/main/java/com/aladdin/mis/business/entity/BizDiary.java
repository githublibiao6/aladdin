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
 * 日记表
 * @author cles
 * @date 2024-09-01 20:50:27
*/
@Table("biz_diary")
@Data
public class BizDiary extends GlobalModel {

    /**
     * userId用户主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * userName
     */
    @TableField("user_name")
    private String userName;

    /**
     * userPic
     */
    @TableField("user_pic")
    private String userPic;

    /**
     * content日记内容
     */
    @TableField("content")
    private String content;

    /**
     * createDate写入日期
     */
    @TableField("create_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    /**
     * createTime写入时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
