package com.aladdin.mis.build.service;

import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.base.service.GlobalService;
/**
 * BuildFormService
 * @author cles
 * @date 2023-02-04 23:26:19
*/
public interface BuildFormService extends GlobalService<BuildForm>  {

    /**
     * 保存配置
     * @param buildFormVo
     * @return
     */
    Integer saveConfig(BuildFormVo buildFormVo);

    /**
     * 获取配置中心
     * @param formId
     * @return
     */
    BuildFormVo getConfigByForm(Integer formId);

    /**
     * 复制配置中心
     * @param buildFormVo
     * @return
     */
    BuildFormVo copyConfigByForm(BuildFormVo buildFormVo);
}
