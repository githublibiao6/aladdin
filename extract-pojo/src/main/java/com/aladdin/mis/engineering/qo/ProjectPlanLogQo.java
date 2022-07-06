package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目计划日志查询实体 
 * @author cles
 * @date 2022-07-06 23:03:24
*/
@Data
public class ProjectPlanLogQo extends ProjectPlanLog {

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
