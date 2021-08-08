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
 * 菜单model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Table("be_role")
@Data
public class Role extends GlobalModel {
    private String code;
    private String name;
    private String comments;

}
