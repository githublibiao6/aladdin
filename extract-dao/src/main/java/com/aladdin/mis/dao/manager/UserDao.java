package com.aladdin.mis.dao.manager;

import com.aladdin.mis.chat.manager.bean.User;
import com.aladdin.mis.chat.manager.qo.UserQo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典 Dao
 * @author lb
 *
 */
@Repository
public interface UserDao {

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
    List<User> listUser(UserQo qo);

}
