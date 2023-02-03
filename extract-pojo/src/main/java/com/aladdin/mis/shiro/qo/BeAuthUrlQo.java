package com.aladdin.mis.shiro.qo;

import com.aladdin.mis.shiro.entity.BeAuthUrl;
import lombok.Data;

/**
 * shiro 配置urls查询实体
 * @author cles
 * @date 2023-02-03 23:50:29
*/
@Data
public class BeAuthUrlQo extends BeAuthUrl {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过滤
     */
    private String  keyWord;
    /**
     * 排序条件
     */
    private String  sortInfo;
}
