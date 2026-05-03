package com.aladdin.mis.identity.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 用户资产表
 * @author cles
 * @date 2024-09-01 23:28:25
*/
@Table("user_property")
@Data
public class UserProperty extends GlobalModel {

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * category类别 1 收入 2 支出
     */
    @TableField("category")
    private Integer category;

    /**
     * type积分类型
     */
    @TableField("type")
    private Integer type;

    /**
     * number积分数量
     */
    @TableField("number")
    private Integer number;

    /**
     * currentNumber当前数量
     */
    @TableField("current_number")
    private Integer currentNumber;

    /**
     * relationId关联表id
     */
    @TableField("relation_id")
    private Integer relationId;

    /**
     * remark备注
     */
    @TableField("remark")
    private String remark;

    /**
     * comments说明
     */
    @TableField("comments")
    private String comments;

}
