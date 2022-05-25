package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectFile;
/**
 * ProjectFileService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
public interface ProjectFileService extends GlobalService<ProjectFile>  {


    /**
     * 更新数据
     * @param entity 文件内容
     * @return flag
     */
    boolean update(ProjectFile entity);

    /**
     * 新建文件
     * @param entity 文件内容
     * @return flag
     */
    boolean save(ProjectFile entity);

    /**
     * 作废文件
     * @param entity
     * @return
     */
    boolean cancellation(ProjectFile entity);

    /**
     * 重启文件
     * @param entity
     * @return
     */
    boolean recover(ProjectFile entity);
}
