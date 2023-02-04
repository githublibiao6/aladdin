package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.build.vo.BuildModularVo;
import com.aladdin.mis.build.qo.BuildModularQo;
import com.aladdin.mis.dao.build.BuildModularDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;
/**
 * BuildModularService
 * @author cles
 * @date 2023-02-04 23:28:02
*/
@Service
public class BuildModularServiceImpl extends GlobalServiceImpl<BuildModular> implements BuildModularService{

    @Autowired
    private BuildModularDao buildModularDao;

}

