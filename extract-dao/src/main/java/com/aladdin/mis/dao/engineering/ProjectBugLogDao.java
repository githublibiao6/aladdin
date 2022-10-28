package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectBugLogQo;
import com.aladdin.mis.engineering.vo.ProjectBugLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectBugLogDao
 * @author cles
 * @date 2022-06-07T00:17:39.543
*/
@Repository
public interface ProjectBugLogDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectBugLogVo> list(ProjectBugLogQo qo);
}
