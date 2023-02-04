package com.aladdin.mis.build.qo;

import com.aladdin.mis.build.entity.BuildModular;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 搭建组件查询实体 
 * @author cles
 * @date 2023-02-04 22:50:09
*/
@Data
public class BuildModularQo extends BuildModular {

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
