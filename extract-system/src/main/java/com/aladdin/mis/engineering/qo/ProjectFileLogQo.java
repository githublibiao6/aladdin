package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectFileLog;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目文件记录查询实体 
 * @author cles
 * @date 2022-05-25T00:28:57.848
*/
@Data
public class ProjectFileLogQo extends ProjectFileLog {

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
