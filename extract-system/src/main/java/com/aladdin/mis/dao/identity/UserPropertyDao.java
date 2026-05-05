package com.aladdin.mis.dao.identity;

import com.aladdin.mis.identity.entity.UserProperty;
import com.aladdin.mis.identity.qo.UserPropertyQo;
import com.aladdin.mis.identity.vo.UserPropertyVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * UserPropertyDao
 * @author cles
 * @date 2024-09-01T23:28:25.806
*/
@Repository
public interface UserPropertyDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<UserPropertyVo> list(UserPropertyQo qo);
}
