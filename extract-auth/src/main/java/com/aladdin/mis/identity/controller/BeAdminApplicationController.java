package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.identity.entity.BeAdminApplication;
import com.aladdin.mis.identity.service.BeAdminApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  BeAdminApplicationService---
 * @author cles
 * @date 2024-08-21 03:38:11
*/
@RequestMapping("/beAdminApplication")
@Controller
public class BeAdminApplicationController  extends GlobalController<BeAdminApplication, BeAdminApplicationService> {

}
