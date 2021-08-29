package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2021-08-29T23:32:31.854
*/
@Repository
public interface ProjectPlanUserDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectPlanUserVo> paginate(ProjectPlanUserQo qo);}
