package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectBugUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 缺陷人员设置查询实体 
 * @author cles
 * @date 2022-06-07T00:17:46.093
*/
@Data
public class ProjectBugUserQo extends ProjectBugUser {

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
