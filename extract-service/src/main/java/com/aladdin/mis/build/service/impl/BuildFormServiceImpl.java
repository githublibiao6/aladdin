package com.aladdin.mis.build.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aladdin.mis.build.entity.BuildForm;
import com.aladdin.mis.build.service.BuildFormService;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.build.vo.BuildFormVo;
import com.aladdin.mis.build.vo.BuildModularVo;
import com.aladdin.mis.build.vo.ModularConfig;
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
        Integer formId = buildFormVo.getId();
        if(formId == null){
            formId = insert(buildFormVo);
        }else {
            updateSelective(buildFormVo);
        }
        if(list != null){
            for (BuildModularVo t : list){
                if(t.getId() == null){
                    t.setFormId(formId);
                    buildModularService.insert(t);
                }else {
                    buildModularService.updateSelective(t);
                }
            }
        }
        return formId;
    }

    @Override
    public BuildFormVo getConfigByForm(Integer formId) {
        BuildFormVo vo = (BuildFormVo) detailQueryVo(formId, BuildFormVo.class);
        List<BuildModularVo> fields = buildModularService.listByFormId(formId);
        if(fields != null){
            fields.forEach(t->{
                ModularConfig config = BeanUtil.copyProperties(t, ModularConfig.class);
                t.set_config_(config);
            });
        }
        vo.setFields(fields);
        return vo;
    }
}

