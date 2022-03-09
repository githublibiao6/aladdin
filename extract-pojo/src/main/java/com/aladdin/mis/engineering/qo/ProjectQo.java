package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.Project;
import lombok.Data;

/**
 * 工程项目查询实体
 * @author cles
 * @date 2021-08-26T23:02:39.362
*/
@Data
public class ProjectQo extends Project {


    private Integer page;

    private Integer limit;
    /**
     * 关键字
     */
    private String keyWord;

}
