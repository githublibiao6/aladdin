package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectEditionLogQo;
import com.aladdin.mis.engineering.vo.ProjectEditionLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectEditionLogDao
 * @author cles
 * @date 2022-05-19T22:18:45.792
*/
@Repository
public interface ProjectEditionLogDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectEditionLogVo> list(ProjectEditionLogQo qo);
}
