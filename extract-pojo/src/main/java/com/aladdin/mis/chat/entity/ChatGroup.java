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
 * 聊天组群
 * @author cles
 * @date 2024-08-30 00:19:09
*/
@Table("chat_group")
@Data
public class ChatGroup extends GlobalModel {

    /**
     * groupNum群号码
     */
    @TableField("group_num")
    private Integer groupNum;

    /**
     * groupCode群二维码
     */
    @TableField("group_code")
    private String groupCode;

    /**
     * groupName会话名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * groupKind组群
     */
    @TableField("group_kind")
    private Integer groupKind;

    /**
     * groupNotice群公告
     */
    @TableField("group_notice")
    private String groupNotice;

    /**
     * createTime创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * createUser创建者
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * createCity创建城市
     */
    @TableField("create_city")
    private Integer createCity;

    /**
     * groupLevel群等级
     */
    @TableField("group_level")
    private Integer groupLevel;

    /**
     * groupStar群星等级 1-9 星
     */
    @TableField("group_star")
    private Integer groupStar;

    /**
     * groupUser群人数
     */
    @TableField("group_user")
    private Integer groupUser;

    /**
     * maxNum最大群人数
     */
    @TableField("max_num")
    private Integer maxNum;

    /**
     * searchWay群查找方式
     */
    @TableField("search_way")
    private Integer searchWay;

    /**
     * joinWay加入规则 1 随意加入，2 审核 
     */
    @TableField("join_way")
    private Integer joinWay;

    /**
     * forbiddenSpeak是否禁言
     */
    @TableField("forbidden_speak")
    private Integer forbiddenSpeak;

    /**
     * label群标签
     */
    @TableField("label")
    private String label;

}
