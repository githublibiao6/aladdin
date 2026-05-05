package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectTableLogQo;
import com.aladdin.mis.engineering.vo.ProjectTableLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTableLogDao
 * @author cles
 * @date 2022-06-22T21:14:00.874
*/
@Repository
public interface ProjectTableLogDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTableLogVo> list(ProjectTableLogQo qo);
}
