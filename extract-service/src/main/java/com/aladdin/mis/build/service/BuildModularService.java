package com.aladdin.mis.build.service;

import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.base.service.GlobalService;

import java.util.List;

/**
 * BuildModularService
 * @author cles
 * @date 2023-02-04 23:28:02
*/
public interface BuildModularService extends GlobalService<BuildModular>  {

    /**
     * 根据formId获取配置组件
     * @param formId
     * @return
     */
    List<BuildModular> listByFormId(Integer formId);
}
