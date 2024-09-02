package com.aladdin.mis.business.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 便签提醒设置表
 * @author cles
 * @date 2024-09-01 22:34:24
*/
@Table("biz_memo_remind")
@Data
public class BizMemoRemind extends GlobalModel {

    /**
     * memoId便签
     */
    @TableField("memo_id")
    private Integer memoId;

    /**
     * remindDate提醒日期
     */
    @TableField("remind_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate remindDate;

    /**
     * remindTime提醒时间
     */
    @TableField("remind_time")
    private LocalTime remindTime;

    /**
     * repeatType重复类型 0 不重复， 1 按天 2, 按周 3 按月 4 按年 9 其他
     */
    @TableField("repeat_type")
    private Integer repeatType;

    /**
     * intervalCycle间隔周期
     */
    @TableField("interval_cycle")
    private Integer intervalCycle;

    /**
     * cycleParam记录设置重复的参数
     */
    @TableField("cycle_param")
    private String cycleParam;

    /**
     * endDate截止日期
     */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    /**
     * repeatRemind重复提醒 1 30分钟 2 1小时 2 2小时
     */
    @TableField("repeat_remind")
    private Integer repeatRemind;

}
