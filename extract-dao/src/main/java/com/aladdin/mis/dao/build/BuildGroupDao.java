package com.aladdin.mis.dao.build;

import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.qo.BuildGroupQo;
import com.aladdin.mis.build.vo.BuildGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BuildGroupDao
 * @author cles
 * @date 2023-01-12T23:01:40.767
*/
@Repository
public interface BuildGroupDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BuildGroupVo> list(BuildGroupQo qo);
}