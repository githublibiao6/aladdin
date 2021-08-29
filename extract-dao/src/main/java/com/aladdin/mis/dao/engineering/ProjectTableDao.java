package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.qo.ProjectTableQo;
import com.aladdin.mis.engineering.vo.ProjectTableVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTableService
 * @author cles
 * @date 2021-08-29T23:32:52.585
*/
@Repository
public interface ProjectTableDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTableVo> paginate(ProjectTableQo qo);}
