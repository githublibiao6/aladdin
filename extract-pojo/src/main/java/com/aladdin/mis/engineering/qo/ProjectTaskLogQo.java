package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import lombok.Data;

/**
 * 项目计划日志查询实体
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@Data
public class ProjectTaskLogQo extends ProjectTaskLog {

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
