package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import com.aladdin.mis.manager.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * user controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("userbaseinfo")
@Controller
public class UserBaseInfoController extends GlobalController<UserBaseInfo, UserBaseInfoService> {

    @Autowired
    private UserBaseInfoService service;

    @Override
    protected GlobalService<UserBaseInfo> getBaseService() {
        return service;
    }


}
