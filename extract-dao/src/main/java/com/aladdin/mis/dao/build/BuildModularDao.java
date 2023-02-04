package com.aladdin.mis.dao.build;

import com.aladdin.mis.build.entity.BuildModular;
import com.aladdin.mis.build.qo.BuildModularQo;
import com.aladdin.mis.build.vo.BuildModularVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BuildModularDao
 * @author cles
 * @date 2023-02-04T23:28:02.121
*/
@Repository
public interface BuildModularDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BuildModularVo> list(BuildModularQo qo);
}
