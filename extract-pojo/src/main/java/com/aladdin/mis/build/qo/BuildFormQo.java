package com.aladdin.mis.build.qo;

import com.aladdin.mis.build.entity.BuildForm;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 查询实体 
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@Data
public class BuildFormQo extends BuildForm {

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
