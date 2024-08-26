package com.aladdin.mis.dao.identity;

import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.qo.BeApplicationQo;
import com.aladdin.mis.identity.vo.BeApplicationVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * BeApplicationDao
 * @author cles
 * @date 2024-08-21T03:21:11.562
*/
@Repository
public interface BeApplicationDao {
    /**
     * 列表
     * @param qo
     * @return list
     */
    List<BeApplicationVo> list(BeApplicationQo qo);

    /**
     * 获取应用
     * @param appKey appKey
     * @param appSecret appSecret
     * @return entity
     */
    BeApplication getByKeyAndSecret(@Param("appKey") String appKey, @Param("appSecret") String appSecret);

    /**
     * 根据adminId获取appList
     * @param adminId
     * @return
     */
    List<BeApplicationVo> getByAdminId(@Param("adminId")Integer adminId);
}
