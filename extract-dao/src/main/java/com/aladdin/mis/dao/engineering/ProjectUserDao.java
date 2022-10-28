package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.788
*/
@Repository
public interface ProjectUserDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectUserVo> list(ProjectUserQo qo);

    /**
     * 获取项目人员详细信息
     * @param condition
     * @return
     */
    List<ProjectUserVo> listVo(ProjectUserQo condition);
}
