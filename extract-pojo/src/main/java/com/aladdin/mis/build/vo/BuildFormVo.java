package com.aladdin.mis.build.vo;

import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.entity.BuildModular;
import lombok.Data;

import java.util.List;

/**
 * 应用层实体
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@Data
public class BuildFormVo extends BuildForm {

    /**
     * 组件配置列表
     */
    private List<BuildModular> fields;
}
