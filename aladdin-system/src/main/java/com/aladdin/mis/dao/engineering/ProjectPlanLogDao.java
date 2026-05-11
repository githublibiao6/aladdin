package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectPlanLogQo;
import com.aladdin.mis.engineering.vo.ProjectPlanLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectPlanLogDao
 * @author cles
 * @date 2022-07-06T23:03:24.354
*/
@Repository
public interface ProjectPlanLogDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectPlanLogVo> list(ProjectPlanLogQo qo);
}
