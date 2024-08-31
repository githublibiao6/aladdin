package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizPostReply;
import com.aladdin.mis.business.service.BizPostReplyService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizPostReplyQo;
import com.aladdin.mis.business.vo.BizPostReplyVo;
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
 * 帖子回复表 BizPostReplyService--- 
 * @author cles
 * @date 2024-08-31 21:52:48
*/
@RequestMapping("/bizPostReply")
@Controller
public class BizPostReplyController  extends GlobalController<BizPostReply, BizPostReplyService> {

}
