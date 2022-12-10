package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTable;
import lombok.Data;

/**
 * 项目表查询实体
 * @author cles
 * @date 2021-09-14T00:07:18.671
*/
@Data
public class ProjectTableQo extends ProjectTable {

    private Integer page;

    private Integer limit;
}
