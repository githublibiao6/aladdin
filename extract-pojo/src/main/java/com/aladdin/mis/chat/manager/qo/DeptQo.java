package com.aladdin.mis.chat.manager.qo;

import com.aladdin.mis.chat.manager.bean.Dept;
import lombok.Data;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class DeptQo  extends Dept {

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer limit;

}
