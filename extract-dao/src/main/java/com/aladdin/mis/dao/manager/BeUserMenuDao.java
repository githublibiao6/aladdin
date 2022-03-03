package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.qo.BeUserMenuQo;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeUserMenuDao
 * @author cles
 * @date 2022-03-01T22:38:09.260
*/
@Repository
public interface BeUserMenuDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeUserMenuVo> list(BeUserMenuQo qo);

    /**
     * 删除用户所有用的全系
     * @param userId
     */
    void removeByUserId(Integer userId);
}
