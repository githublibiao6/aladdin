package com.aladdin.mis.business.controller;

import com.aladdin.mis.business.entity.BizDiary;
import com.aladdin.mis.business.service.BizDiaryService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.business.qo.BizDiaryQo;
import com.aladdin.mis.business.vo.BizDiaryVo;
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
 * 日记表 BizDiaryService--- 
 * @author cles
 * @date 2024-09-01 20:50:27
*/
@RequestMapping("/bizDiary")
@Controller
public class BizDiaryController  extends GlobalController<BizDiary, BizDiaryService> {

}
