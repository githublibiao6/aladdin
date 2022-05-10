package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.qo.ProjectEditionQo;
import com.aladdin.mis.engineering.vo.ProjectEditionVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectEditionDao
 * @author cles
 * @date 2022-05-11T01:37:39.286
*/
@Repository
public interface ProjectEditionDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectEditionVo> list(ProjectEditionQo qo);
}
