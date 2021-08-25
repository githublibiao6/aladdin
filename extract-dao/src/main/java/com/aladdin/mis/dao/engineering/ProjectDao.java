package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.Project;
import com.aladdin.mis.engineering.qo.ProjectQo;
import com.aladdin.mis.engineering.vo.ProjectVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectService
 * @author cles
 * @date 2021-08-25T23:05:09.518
*/
@Repository
public interface ProjectDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectVo> paginate(ProjectQo qo);}
