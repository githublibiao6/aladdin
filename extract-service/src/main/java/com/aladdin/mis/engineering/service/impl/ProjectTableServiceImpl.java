package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectTableDao;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.service.ProjectTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectTableService
 * @author cles
 * @date 2021-09-14T00:07:18.685
*/
@Service
public class ProjectTableServiceImpl extends GlobalServiceImpl<ProjectTable> implements ProjectTableService{

    @Autowired
    private ProjectTableDao projectTableDao;


}

