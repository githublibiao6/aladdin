package com.aladdin.mis.pagehelper.entity.qo;

import com.aladdin.mis.manager.bean.Menu;
import lombok.Data;

/**
 *  分页实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class MenuQo extends Menu {
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页数量
     */
    private Integer limit;

}
