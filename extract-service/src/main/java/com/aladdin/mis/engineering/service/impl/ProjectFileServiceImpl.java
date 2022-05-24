package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectFileService;
import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.dao.engineering.ProjectFileDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * ProjectFileService
 * @author cles
 * @date 2022-05-25T00:29:11.439
*/
@Service
public class ProjectFileServiceImpl extends GlobalServiceImpl<ProjectFile> implements ProjectFileService{

    @Autowired
    private ProjectFileDao projectFileDao;

}

