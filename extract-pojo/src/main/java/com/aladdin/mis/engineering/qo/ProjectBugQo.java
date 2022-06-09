package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectBug;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目缺陷管理查询实体 
 * @author cles
 * @date 2022-06-07T00:17:28.281
*/
@Data
public class ProjectBugQo extends ProjectBug {

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