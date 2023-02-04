package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.build.service.BuildGroupService;
import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.vo.BuildGroupVo;
import com.aladdin.mis.build.qo.BuildGroupQo;
import com.aladdin.mis.dao.build.BuildGroupDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;
/**
 * BuildGroupService
 * @author cles
 * @date 2023-02-04 23:27:32
*/
@Service
public class BuildGroupServiceImpl extends GlobalServiceImpl<BuildGroup> implements BuildGroupService{

    @Autowired
    private BuildGroupDao buildGroupDao;

}

