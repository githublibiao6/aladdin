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
 * 便签组表
 * @author cles
 * @date 2024-09-15 23:15:54
*/
@Table("biz_memo_group")
@Data
public class BizMemoGroup extends GlobalModel {

    /**
     * userId用户主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * groupNumber组编码
     */
    @TableField("group_number")
    private Integer groupNumber;

    /**
     * groupName便签分组名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * orderNum排序
     */
    @TableField("order_num")
    private Integer orderNum;

}
