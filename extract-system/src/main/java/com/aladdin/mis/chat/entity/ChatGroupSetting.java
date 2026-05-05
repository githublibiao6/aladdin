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
 * 聊天组群-设置信息
 * @author cles
 * @date 2024-08-30 00:21:21
*/
@Table("chat_group_setting")
@Data
public class ChatGroupSetting extends GlobalModel {

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

}
