package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectFileDao
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
@Repository
public interface ProjectFileDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectFileVo> list(ProjectFileQo qo);
}
