package com.aladdin.mis.dao.identity;

import com.aladdin.mis.identity.entity.UserScore;
import com.aladdin.mis.identity.qo.UserScoreQo;
import com.aladdin.mis.identity.vo.UserScoreVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * UserScoreDao
 * @author cles
 * @date 2024-09-01T23:28:33.454
*/
@Repository
public interface UserScoreDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<UserScoreVo> list(UserScoreQo qo);
}
