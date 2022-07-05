package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 任务人员设置查询实体 
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@Data
public class ProjectTaskUserQo extends ProjectTaskUser {

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
