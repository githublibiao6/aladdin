package com.aladdin.mis.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 管理员实体类
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("be_img")
@Data
public class Img extends GlobalModel {

    /**
     * 类别
     */
    private String code;

    /**
     * 唯一标识
     */
    @TableField("unique_key")
    private String uniqueKey;

    /**
     * 图片地址
     */
    private String url;
}
