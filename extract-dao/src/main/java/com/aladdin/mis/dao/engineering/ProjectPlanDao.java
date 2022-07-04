package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectPlanDao
 * @author cles
 * @date 2022-07-04T21:42:33.372
*/
@Repository
public interface ProjectPlanDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectPlanVo> list(ProjectPlanQo qo);
}
