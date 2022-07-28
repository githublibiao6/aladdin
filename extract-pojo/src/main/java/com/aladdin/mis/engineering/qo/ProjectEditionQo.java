package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectEdition;
import lombok.Data;

/**
 * 项目版本记录查询实体
 * @author cles
 * @date 2022-05-11T01:37:39.282
*/
@Data
public class ProjectEditionQo extends ProjectEdition {

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

    /**
     * 当前用户查询
     */
    private Integer  userId;
}
