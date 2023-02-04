package com.aladdin.mis.build.qo;

import com.aladdin.mis.build.entity.BuildGroup;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 建设大类查询实体 
 * @author cles
 * @date 2023-02-04 23:27:32
*/
@Data
public class BuildGroupQo extends BuildGroup {

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
