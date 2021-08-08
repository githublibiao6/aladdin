package com.aladdin.mis.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 部门 类
 *
 * @author lb
 */
@Table("be_dept")
@Data
public class Dept extends GlobalModel {
    /**
     * 编号
     */
    private String code;
    /**
    * 部门名称
     */
    private String name;
    /**
     * 说明
     */
    private String comments;

}
