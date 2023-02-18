package com.aladdin.mis.engineering.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
import com.github.pagehelper.PageInfo;

/**
 * ProjectFileService
 * @author cles
 * @date 2022-05-25T00:29:11.438
*/
public interface ProjectFileService extends GlobalService<ProjectFile>  {

    /**
     * 分页获取数据
     * @param qo
     * @return
     */
    PageInfo<ProjectFileVo> pageByDto(ProjectFileQo qo);

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

    /**
     * 删除文件
     * @param entity
     * @return
     */
    boolean deleteFile(ProjectFile entity);

    /**
     * 下载文件
     * @param entity
     * @return
     */
    boolean downloadFile(ProjectFile entity);

}
