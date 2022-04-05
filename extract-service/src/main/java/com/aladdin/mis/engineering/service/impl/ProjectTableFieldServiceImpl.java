package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectTableFieldDao;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@Service
public class ProjectTableFieldServiceImpl extends GlobalServiceImpl<ProjectTableField> implements ProjectTableFieldService{

    @Autowired
    private ProjectTableFieldDao projectTableFieldDao;


}

