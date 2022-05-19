package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目版本记录查询实体 
 * @author cles
 * @date 2022-05-19T22:18:45.682
*/
@Data
public class ProjectEditionLogQo extends ProjectEditionLog {

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
