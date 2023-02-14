package com.aladdin.mis.build.service.impl;

import com.aladdin.mis.base.qo.Condition;
import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.build.service.BuildModularService;
import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.build.BuildModularDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * BuildModularService
 * @author cles
 * @date 2023-02-04 23:28:02
*/
@Service
public class BuildModularServiceImpl extends GlobalServiceImpl<BuildModular> implements BuildModularService{

    @Autowired
    private BuildModularDao buildModularDao;

    @Override
    public List<BuildModular> listByFormId(Integer formId) {
        Condition condition = Condition.newInstance().addExpression("sys005",1);
        condition.addExpression("formId",formId);
        return queryByCondition(condition);
    }
}

