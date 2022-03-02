package com.aladdin.mis.manager.vo;

import com.aladdin.mis.manager.entity.BeUserMenu;
import lombok.Data;

/**
 * 应用层实体
 * @author cles
 * @date 2022-03-01T22:38:09.248
*/
@Data
public class BeUserMenuVo extends BeUserMenu {

    /**
     * 是否选中状态
     */
    private boolean disabled;

    /**
     * 是否选中状态
     */
    private Integer roleId;

}
