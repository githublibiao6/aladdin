package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizPost;
import com.aladdin.mis.business.service.BizPostService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizPostQo;
import com.aladdin.mis.business.vo.BizPostVo;
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
 * 帖子 BizPostService--- 
 * @author cles
 * @date 2024-08-31 21:50:30
*/
@RequestMapping("/bizPost")
@Controller
public class BizPostController  extends GlobalController<BizPost, BizPostService> {

}
