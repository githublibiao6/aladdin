package com.aladdin.mis.identity.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 应用表
 * @author cles
 * @date 2024-08-21 03:18:00
*/
@Table("be_application")
@Data
public class BeApplication extends GlobalModel {

    /**
     * appCode
     */
    @TableField("app_code")
    private String appCode;

    /**
     * appName
     */
    @TableField("app_name")
    private String appName;

    /**
     * appKey
     */
    @TableField("app_key")
    private String appKey;

    /**
     * appSecret
     */
    @TableField("app_secret")
    private String appSecret;

    /**
     * contractMan联系人
     */
    @TableField("contract_man")
    private String contractMan;

    /**
     * contractPhone联系电话
     */
    @TableField("contract_phone")
    private String contractPhone;

}
