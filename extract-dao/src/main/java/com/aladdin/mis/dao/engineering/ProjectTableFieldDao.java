package com.aladdin.mis.dao.engineering;

import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.qo.ProjectTableFieldQo;
import com.aladdin.mis.engineering.vo.ProjectTableFieldVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ProjectTableFieldService
 * @author cles
 * @date 2021-08-31T22:05:10.401
*/
@Repository
public interface ProjectTableFieldDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<ProjectTableFieldVo> paginate(ProjectTableFieldQo qo);}
