package com.aladdin.mis.shiro.controller;

import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.shiro.entity.BeAuthUrl;
import com.aladdin.mis.shiro.service.BeAuthUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * shiro 配置urls BeAuthUrlService---
 * @author cles
 * @date 2023-02-03 23:50:29
*/
@RequestMapping("shiro/beAuthUrl")
@Controller
public class BeAuthUrlController  extends GlobalController<BeAuthUrl, BeAuthUrlService> {

}
