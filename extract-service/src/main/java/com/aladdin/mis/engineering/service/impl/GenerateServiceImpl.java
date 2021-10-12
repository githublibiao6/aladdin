package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.dao.engineering.GenerateDao;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.engineering.qo.GenerateQo;
import com.aladdin.mis.engineering.service.GenerateService;
import com.aladdin.mis.engineering.vo.GenerateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectPlanService
 * @author cles
 * @date 2021-08-31T22:26:17.069
*/
@Service
public class GenerateServiceImpl  implements GenerateService {

    @Autowired
    private GenerateDao generateDao;

    @Override
    public List<GenerateVo> paginate(GenerateQo qo) {
        String tableSchema = Db.use().getTableSchema();
        qo.setTableSchema(tableSchema);
        return generateDao.listTable(qo);
    }
}

