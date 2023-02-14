package com.aladdin.mis.build.vo;

import com.aladdin.mis.build.entity.BuildModular;
import lombok.Data;

/**
 * 搭建组件应用层实体
 * @author cles
 * @date 2023-02-04 23:28:02
*/
@Data
public class BuildModularVo extends BuildModular {

    /**
     * 对应前端的__config__
     */
    private ModularConfig __config__;
}
