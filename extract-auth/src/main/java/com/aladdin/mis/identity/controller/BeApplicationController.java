package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.service.BeApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用表 BeApplicationService---
 * @author cles
 * @date 2024-08-21 03:18:00
*/
@RequestMapping("/beApplication")
@Controller
public class BeApplicationController  extends GlobalController<BeApplication, BeApplicationService> {

}
