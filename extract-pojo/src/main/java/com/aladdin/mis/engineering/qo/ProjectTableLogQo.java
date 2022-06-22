package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTableLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目表日志查询实体 
 * @author cles
 * @date 2022-06-22T21:14:00.824
*/
@Data
public class ProjectTableLogQo extends ProjectTableLog {

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
