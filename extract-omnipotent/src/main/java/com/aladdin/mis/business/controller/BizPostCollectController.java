package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizPostCollect;
import com.aladdin.mis.business.service.BizPostCollectService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizPostCollectQo;
import com.aladdin.mis.business.vo.BizPostCollectVo;
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
 * 点赞表 BizPostCollectService--- 
 * @author cles
 * @date 2024-08-31 21:53:08
*/
@RequestMapping("/bizPostCollect")
@Controller
public class BizPostCollectController  extends GlobalController<BizPostCollect, BizPostCollectService> {

}
