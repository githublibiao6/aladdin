package com.apps.omnipotent.manager.bean;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.core.TableField;
import com.apps.omnipotent.system.global.entity.GlobalModel;

/**
 * 管理员实体类
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("be_img")
public class Img extends GlobalModel {

    /**
     * 主键
     */
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
