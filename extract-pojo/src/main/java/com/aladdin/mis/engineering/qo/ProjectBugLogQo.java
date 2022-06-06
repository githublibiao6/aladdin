package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectBugLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目权限日志查询实体 
 * @author cles
 * @date 2022-06-07T00:17:39.539
*/
@Data
public class ProjectBugLogQo extends ProjectBugLog {

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
