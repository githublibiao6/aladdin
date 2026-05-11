package com.aladdin.mis.shiro.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * shiro 配置urls
 * @author cles
 * @date 2023-02-03 23:50:29
*/
@Table("be_auth_url")
@Data
public class BeAuthUrl extends GlobalModel {

    /**
     * url
     */
    @TableField("url")
    private String url;

    /**
     * permission
     */
    @TableField("permission")
    private String permission;

    /**
     * order
     */
    @TableField("sort")
    private Integer sort;

}
