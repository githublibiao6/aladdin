package com.aladdin.mis.build.qo;

import com.aladdin.mis.build.entity.BuildGroup;
import lombok.Data;

/**
 * 建设大类查询实体
 * @author cles
 * @date 2023-01-12 23:01:40
*/
@Data
public class BuildGroupQo extends BuildGroup {

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
