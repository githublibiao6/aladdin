package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import com.aladdin.mis.engineering.qo.ProjectTaskUserQo;
import com.aladdin.mis.engineering.vo.ProjectTaskUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTaskUserDao
 * @author cles
 * @date 2022-07-05T21:57:55.370
*/
@Repository
public interface ProjectTaskUserDao {

    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTaskUserVo> list(ProjectTaskUserQo qo);

    /**
     * 根据任务和人员查询
     * @param id
     * @param userId
     * @return
     */
    ProjectTaskUser getByTaskAndUserId(Integer id, Integer userId);
}
