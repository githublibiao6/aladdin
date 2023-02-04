package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.service.BuildFormService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.build.qo.BuildFormQo;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import com.aladdin.mis.common.system.service.GlobalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 *  BuildFormService--- 
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@RequestMapping("build/buildForm")
@Controller
public class BuildFormController  extends GlobalController<BuildForm, BuildFormService> {

}
