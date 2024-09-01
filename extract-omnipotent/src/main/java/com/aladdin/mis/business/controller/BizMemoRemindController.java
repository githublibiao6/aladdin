package com.aladdin.mis.business.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.entity.BizMemoRemind;
import com.aladdin.mis.business.service.BizMemoRemindService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 便签提醒设置表 BizMemoRemindService---
 * @author cles
 * @date 2024-09-01 22:26:11
*/
@RequestMapping("/bizMemoRemind")
@Controller
public class BizMemoRemindController  extends GlobalController<BizMemoRemind, BizMemoRemindService> {

}
