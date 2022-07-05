package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.qo.ProjectTaskQo;
import com.aladdin.mis.engineering.vo.ProjectTaskVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTaskDao
 * @author cles
 * @date 2022-07-05T21:58:00.274
*/
@Repository
public interface ProjectTaskDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTaskVo> list(ProjectTaskQo qo);
}
