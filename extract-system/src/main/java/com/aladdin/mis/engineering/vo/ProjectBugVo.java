package com.aladdin.mis.engineering.vo;

import com.aladdin.mis.engineering.entity.ProjectBug;
import lombok.Data;

/**
 * 项目缺陷管理应用层实体
 * @author cles
 * @date 2022-06-07T00:17:28.334
*/
@Data
public class ProjectBugVo extends ProjectBug {

    /**
     * 创建人
     */
    private String foundPerson;

    /**
     * 修复人
     */
    private String fixPerson;

}
