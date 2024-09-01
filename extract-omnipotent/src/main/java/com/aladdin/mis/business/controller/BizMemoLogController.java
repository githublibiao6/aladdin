package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizMemoLog;
import com.aladdin.mis.business.service.BizMemoLogService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizMemoLogQo;
import com.aladdin.mis.business.vo.BizMemoLogVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import com.aladdin.mis.base.service.GlobalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 日记表 BizMemoLogService--- 
 * @author cles
 * @date 2024-09-01 22:25:53
*/
@RequestMapping("/bizMemoLog")
@Controller
public class BizMemoLogController  extends GlobalController<BizMemoLog, BizMemoLogService> {

}
