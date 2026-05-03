package com.aladdin.mis.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 字典对象 Entity
 * @author lb
 *
 */
@Table("be_dictionary_teams")
@Data
public class DictionaryTeams extends GlobalModel {

    /**
     * 字典对象
     */
    @TableField("dic_id")
    private String dicId;

    /**
     *  字典值
     */
    @TableField("dic_value")
    private String dicValue;

    /**
     *  字典项
     */
    @TableField("dic_text")
    private String dicText;

    /**
     *  说明
     */
    private String comments;

    /**
     *  排序
     */
    private String sort;

}
