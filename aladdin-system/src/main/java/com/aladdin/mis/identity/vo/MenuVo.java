package com.aladdin.mis.identity.vo;

import com.aladdin.mis.identity.entity.Menu;
import lombok.Data;

/**
 * 应用层实："
 * @author cles
 * @date 2022-03-01T22:38:09.248
*/
@Data
public class MenuVo extends Menu {

    /**
     * 是否选中状："
     */
    private boolean disabled;

}
