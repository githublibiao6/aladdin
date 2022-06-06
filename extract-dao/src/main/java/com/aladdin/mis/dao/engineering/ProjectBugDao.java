package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectBugDao
 * @author cles
 * @date 2022-06-07T00:17:28.349
*/
@Repository
public interface ProjectBugDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectBugVo> list(ProjectBugQo qo);
}
