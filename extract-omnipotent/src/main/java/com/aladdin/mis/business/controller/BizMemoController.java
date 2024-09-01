package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizMemo;
import com.aladdin.mis.business.service.BizMemoService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizMemoQo;
import com.aladdin.mis.business.vo.BizMemoVo;
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
 * 日记表 BizMemoService--- 
 * @author cles
 * @date 2024-09-01 22:25:16
*/
@RequestMapping("/bizMemo")
@Controller
public class BizMemoController  extends GlobalController<BizMemo, BizMemoService> {

}
