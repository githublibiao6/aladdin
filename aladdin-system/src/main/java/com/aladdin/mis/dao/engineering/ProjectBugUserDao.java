package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectBugUserQo;
import com.aladdin.mis.engineering.vo.ProjectBugUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectBugUserDao
 * @author cles
 * @date 2022-06-07T00:17:46.096
*/
@Repository
public interface ProjectBugUserDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectBugUserVo> list(ProjectBugUserQo qo);
}
