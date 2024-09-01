package com.aladdin.mis.identity.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.identity.entity.UserProperty;
import com.aladdin.mis.identity.service.UserPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户资产表 UserPropertyService---
 * @author cles
 * @date 2024-09-01 23:28:25
*/
@RequestMapping("/userProperty")
@Controller
public class UserPropertyController  extends GlobalController<UserProperty, UserPropertyService> {

}
