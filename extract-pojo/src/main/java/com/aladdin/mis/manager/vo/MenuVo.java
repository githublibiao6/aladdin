package com.aladdin.mis.manager.vo;

import com.aladdin.mis.manager.bean.Menu;
import lombok.Data;

/**
 * 应用层实体
 * @author cles
 * @date 2022-03-01T22:38:09.248
*/
@Data
public class MenuVo extends Menu {

    /**
     * 是否选中状态
     */
    private boolean disabled;

}
