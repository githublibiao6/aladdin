package com.aladdin.mis.omnipotent.manager.bean;

<<<<<<< HEAD
import com.aladdin.mis.omnipotent.system.core.Table;
=======
import com.aladdin.mis.system.annotation.entity.Table;
import com.aladdin.mis.system.annotation.entity.TableField;
>>>>>>> ad7b8372fb695547346b195f89a3479ae6cc4d85
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
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
