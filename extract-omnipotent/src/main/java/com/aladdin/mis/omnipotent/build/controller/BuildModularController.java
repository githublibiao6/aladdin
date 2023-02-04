package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.common.system.controller.GlobalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 搭建组件 BuildModularService---
 * @author cles
 * @date 2023-02-04 23:28:02
*/
@RequestMapping("build/buildModular")
@Controller
public class BuildModularController  extends GlobalController<BuildModular, BuildModularService> {

}
