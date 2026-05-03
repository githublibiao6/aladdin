package com.aladdin.mis.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.system.base.GlobalModel;
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
