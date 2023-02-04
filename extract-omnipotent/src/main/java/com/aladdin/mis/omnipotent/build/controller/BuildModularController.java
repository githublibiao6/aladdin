package com.aladdin.mis.omnipotent.build.controller;

import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.build.qo.BuildModularQo;
import com.aladdin.mis.build.vo.BuildModularVo;
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
 * 搭建组件 BuildModularService--- 
 * @author cles
 * @date 2023-02-04 22:50:09
*/
@RequestMapping("build/buildModular")
@Controller
public class BuildModularController  extends GlobalController<BuildModular, BuildModularService> {

}
