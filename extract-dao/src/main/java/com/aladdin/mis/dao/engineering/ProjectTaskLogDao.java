package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectTaskLogQo;
import com.aladdin.mis.engineering.vo.ProjectTaskLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTaskLogDao
 * @author cles
 * @date 2022-07-05T21:58:10.655
*/
@Repository
public interface ProjectTaskLogDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTaskLogVo> list(ProjectTaskLogQo qo);
}
