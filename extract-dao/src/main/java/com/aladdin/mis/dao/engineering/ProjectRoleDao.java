package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.qo.ProjectRoleQo;
import com.aladdin.mis.engineering.vo.ProjectRoleVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectRoleService
 * @author cles
 * @date 2021-08-29T23:32:45.166
*/
@Repository
public interface ProjectRoleDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectRoleVo> paginate(ProjectRoleQo qo);}
