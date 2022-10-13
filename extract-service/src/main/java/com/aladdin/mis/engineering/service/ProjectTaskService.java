package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.qo.ProjectTaskQo;
import com.aladdin.mis.engineering.vo.ProjectTaskVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * ProjectTaskService
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Service
public interface ProjectTaskService extends GlobalService<ProjectTask>  {

    /**
     * 分页获取任务，会根据人员和角色来获取
     * @param qo
     * @return
     */
    PageInfo<ProjectTaskVo> paginate(ProjectTaskQo qo);

    /**
     * 更新任务
     * @param entity
     * @return
     */
    boolean update(ProjectTask entity);

    /**
     * 保存任务
     * @param entity
     * @return
     */
    boolean save(ProjectTask entity);

    /**
     * 删除任务
     * @param data
     * @return
     */
    boolean deleteTask(ProjectTask data);

    /**
     * 评价任务
     * @param data
     * @return
     */
    boolean closeTask(ProjectTask data);

    /**
     * 开始任务
     * @param entity
     * @return
     */
    boolean startTask(ProjectTask entity);

    /**
     * 挂起任务
     * @param data
     * @return
     */
    boolean hangTask(ProjectTask data);

    /**
     * 继续任务
     * @param data
     * @return
     */
    boolean continueTask(ProjectTask data);

    /**
     * 完成任务
     * @param data
     * @return
     */
    boolean completeTask(ProjectTask data);
}
