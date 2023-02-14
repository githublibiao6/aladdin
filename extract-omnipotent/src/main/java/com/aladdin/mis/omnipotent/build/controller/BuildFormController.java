package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.service.BuildFormService;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  BuildFormService---
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@RequestMapping("/buildForm")
@Controller
public class BuildFormController  extends GlobalController<BuildForm, BuildFormService> {

    /**
     * 保存表单配置
     * @param buildFormVo
     * @return
     */
    @RequestMapping("/saveConfig")
    @ResponseBody
    public Result saveConfig(@RequestBody BuildFormVo buildFormVo) {
        Integer formId = baseService.saveConfig(buildFormVo);
        if(formId != null){
            BuildFormVo vo = baseService.getConfigByForm(formId);
            return Result.success(vo);
        }
        return Result.error();
    }

    /**
     * 复制表单配置
     * @param buildFormVo
     * @return
     */
    @RequestMapping("/copyConfig")
    @ResponseBody
    public Result copyConfigByForm(@RequestBody BuildFormVo buildFormVo) {
        if(buildFormVo.getId() != null){
            BuildFormVo vo = baseService.copyConfigByForm(buildFormVo);
            return Result.success(vo);
        }
        return Result.error();
    }
}
