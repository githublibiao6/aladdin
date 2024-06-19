package com.aladdin.mis.chat.manager.qo;

import com.aladdin.mis.chat.manager.entity.BeUserMenu;
import lombok.Data;

/**
 * 查询实体
 * @author cles
 * @date 2022-03-01T22:38:09.214
*/
@Data
public class BeUserMenuQo extends BeUserMenu {

    private Integer page;

    private Integer limit;
}
