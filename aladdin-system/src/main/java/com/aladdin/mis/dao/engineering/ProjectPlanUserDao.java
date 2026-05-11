package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectPlanUserDao
 * @author cles
 * @date 2022-07-05T21:57:37.625
*/
@Repository
public interface ProjectPlanUserDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectPlanUserVo> list(ProjectPlanUserQo qo);
}
