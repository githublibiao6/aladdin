package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.build.service.BuildFormService;
import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.build.qo.BuildFormQo;
import com.aladdin.mis.dao.build.BuildFormDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;
/**
 * BuildFormService
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@Service
public class BuildFormServiceImpl extends GlobalServiceImpl<BuildForm> implements BuildFormService{

    @Autowired
    private BuildFormDao buildFormDao;

}

