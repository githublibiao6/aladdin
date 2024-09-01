package com.aladdin.mis.identity.controller;

import com.aladdin.mis.identity.entity.UserScore;
import com.aladdin.mis.identity.service.UserScoreService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.identity.qo.UserScoreQo;
import com.aladdin.mis.identity.vo.UserScoreVo;
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
 * 用户积分表 UserScoreService--- 
 * @author cles
 * @date 2024-09-01 23:28:33
*/
@RequestMapping("/userScore")
@Controller
public class UserScoreController  extends GlobalController<UserScore, UserScoreService> {

}
