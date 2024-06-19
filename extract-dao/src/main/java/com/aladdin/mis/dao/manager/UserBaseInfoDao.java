package com.aladdin.mis.dao.manager;

import com.aladdin.mis.chat.manager.bean.UserBaseInfo;
import com.aladdin.mis.chat.manager.qo.UserQo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户基础信息 Dao
 * @author lb
 *
 */
@Repository
public interface UserBaseInfoDao {

    /**
     * 功能描述：
     *  < 获取全部 >
     * @Description: listUser
     * @Author: cles
     * @Date: 2020/7/2 23:09
     * @param qo 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.User>
     * @version: 1.0.0
     */
    List<UserBaseInfo> listUser(UserQo qo);

    /**
     * 获取指定id人员的基本信息数据
     * @param userId
     * @return
     */
    UserBaseInfo getUserInfoByUserId(@Param("userId") Integer userId);

}
