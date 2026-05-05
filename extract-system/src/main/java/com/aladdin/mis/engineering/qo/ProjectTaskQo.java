package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTask;
import lombok.Data;

/**
 * 项目任务表查询实体
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Data
public class ProjectTaskQo extends ProjectTask {

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
