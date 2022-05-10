package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.vo.ProjectEditionVo;
import com.aladdin.mis.engineering.qo.ProjectEditionQo;
import com.aladdin.mis.dao.engineering.ProjectEditionDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectEditionService
 * @author cles
 * @date 2022-05-11T01:37:39.288
*/
@Service
public class ProjectEditionServiceImpl extends GlobalServiceImpl<ProjectEdition> implements ProjectEditionService{

    @Autowired
    private ProjectEditionDao projectEditionDao;

}

