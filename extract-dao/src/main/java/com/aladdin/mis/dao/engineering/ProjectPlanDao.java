package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectPlanService
 * @author cles
 * @date 2021-08-29T23:32:16.049
*/
@Repository
public interface ProjectPlanDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectPlanVo> paginate(ProjectPlanQo qo);}
