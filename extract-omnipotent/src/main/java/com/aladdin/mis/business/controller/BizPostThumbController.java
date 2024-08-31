package com.aladdin.mis.business.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.entity.BizPostThumb;
import com.aladdin.mis.business.service.BizPostThumbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 收藏表 BizPostThumbService---
 * @author cles
 * @date 2024-08-31 21:53:31
*/
@RequestMapping("/bizPostThumb")
@Controller
public class BizPostThumbController  extends GlobalController<BizPostThumb, BizPostThumbService> {

}
