package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.qo.ProjectUserRoleQo;
import com.aladdin.mis.engineering.vo.ProjectUserRoleVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectUserRoleService
 * @author cles
 * @date 2021-08-31T22:03:55.835
*/
@Repository
public interface ProjectUserRoleDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectUserRoleVo> paginate(ProjectUserRoleQo qo);}
