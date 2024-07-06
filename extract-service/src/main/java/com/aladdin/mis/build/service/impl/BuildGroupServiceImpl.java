package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.service.BuildGroupService;
import com.aladdin.mis.dao.build.BuildGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BuildGroupService
 * @author cles
 * @date 2023-02-05 16:40:09
*/
public class BuildGroupServiceImpl extends GlobalServiceImpl<BuildGroup> implements BuildGroupService{

    @Autowired
    private BuildGroupDao buildGroupDao;

}

