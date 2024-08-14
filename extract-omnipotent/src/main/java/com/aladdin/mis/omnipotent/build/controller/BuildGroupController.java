package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.service.BuildGroupService;
import com.aladdin.mis.base.controller.GlobalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 建设大类 BuildGroupService---
 * @author cles
 * @date 2023-02-05 16:40:09
*/
@RequestMapping("/buildGroup")
@Controller
public class BuildGroupController  extends GlobalController<BuildGroup, BuildGroupService> {

}
