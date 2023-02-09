package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.service.BuildFormService;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.build.vo.BuildModularVo;
import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.build.BuildFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BuildFormService
 * @author cles
 * @date 2023-02-04 23:26:19
*/
@Service
public class BuildFormServiceImpl extends GlobalServiceImpl<BuildForm> implements BuildFormService{

    @Autowired
    private BuildFormDao buildFormDao;

    @Autowired
    private BuildModularService buildModularService;

    @Override
    public Integer saveConfig(BuildFormVo buildFormVo) {
        List<BuildModularVo> list = buildFormVo.getFields();
        int formId = insert(buildFormVo);
        if(list != null){
            list.forEach(t->{
                t.setFormId(formId);
                buildModularService.insert(t);
            });
        }
        return formId;
    }

    @Override
    public BuildFormVo getConfigByForm(Integer formId) {
        BuildFormVo vo = (BuildFormVo) detailQueryVo(formId, BuildFormVo.class);
        List<BuildModularVo> fields = buildModularService.listByFormId(formId);
        vo.setFields(fields);
        return vo;
    }
}

