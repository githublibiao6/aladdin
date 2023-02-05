package com.aladdin.mis.dao.build;

import com.aladdin.mis.build.entity.BuildGroup;
import com.aladdin.mis.build.qo.BuildGroupQo;
import com.aladdin.mis.build.vo.BuildGroupVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BuildGroupDao
 * @author cles
 * @date 2023-02-05T16:40:09.197
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
