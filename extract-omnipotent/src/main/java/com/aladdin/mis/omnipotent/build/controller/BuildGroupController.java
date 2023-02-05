package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.service.BuildGroupService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.build.qo.BuildGroupQo;
import com.aladdin.mis.build.vo.BuildGroupVo;
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
 * 建设大类 BuildGroupService--- 
 * @author cles
 * @date 2023-02-05 16:40:09
*/
@RequestMapping("build/buildGroup")
@Controller
public class BuildGroupController  extends GlobalController<BuildGroup, BuildGroupService> {

}
