package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.engineering.vo.ProjectVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectService
 * @author cles
 * @date 2021-08-26T23:02:39.364
*/
@Repository
public interface ProjectDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectVo> list(ProjectQo qo);}
