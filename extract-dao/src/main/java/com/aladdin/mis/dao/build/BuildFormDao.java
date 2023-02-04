package com.aladdin.mis.dao.build;

import com.aladdin.mis.build.qo.BuildFormQo;
import com.aladdin.mis.build.vo.BuildFormVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BuildFormDao
 * @author cles
 * @date 2023-02-04T23:26:19.254
*/
@Repository
public interface BuildFormDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BuildFormVo> list(BuildFormQo qo);
}
