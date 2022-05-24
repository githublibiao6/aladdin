package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.qo.ProjectFileLogQo;
import com.aladdin.mis.engineering.vo.ProjectFileLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectFileLogDao
 * @author cles
 * @date 2022-05-25T00:28:57.882
*/
@Repository
public interface ProjectFileLogDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectFileLogVo> list(ProjectFileLogQo qo);
}
