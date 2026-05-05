package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectFile;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目版本文件资料查询实体 
 * @author cles
 * @date 2022-05-25T00:29:11.436
*/
@Data
public class ProjectFileQo extends ProjectFile {

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
