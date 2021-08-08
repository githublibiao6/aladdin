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
 * 字典 Entity
 * @author cles
 *
 */
@Table("be_dictionary")
@Data
public class Dictionary extends GlobalModel {

    /**
    * 编码
     */
    private String code;
    /**
     *  名称
     */
    private String name;
    /**
     *  说明
     */
    private String comments;

}
