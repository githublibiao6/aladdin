package com.aladdin.mis.build.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 搭建表单
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@Table("build_form")
@Data
public class BuildForm extends GlobalModel {

    /**
     * formRef表单名
     */
    @TableField("formRef")
    private String formRef;

    /**
     * formModel数据模型
     */
    @TableField("formModel")
    private String formModel;

    /**
     * formRules校验模型
     */
    @TableField("formRules")
    private String formRules;

    /**
     * size表单尺寸（medium中等 small较小 mini迷你）
     */
    @TableField("size")
    private String size;

    /**
     * labelPosition标签对齐
     */
    @TableField("labelPosition")
    private String labelPosition;

    /**
     * labelWidth标签宽度
     */
    @TableField("labelWidth")
    private Integer labelWidth;

    /**
     * gutter栅格间隔
     */
    @TableField("gutter")
    private Integer gutter;

    /**
     * disabled禁用表单
     */
    @TableField("disabled")
    private Boolean disabled;

    /**
     * formBtns表单按钮
     */
    @TableField("formBtns")
    private String formBtns;

    /**
     * unFocusedComponentBorder显示未选中组件边框
     */
    @TableField("unFocusedComponentBorder")
    private Boolean unFocusedComponentBorder;

    /**
     * sys000导出值
     */
    @TableField("sys000")
    private Integer sys000;

}
