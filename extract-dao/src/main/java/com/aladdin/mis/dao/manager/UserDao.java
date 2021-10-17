package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.manager.qo.UserQo;
import org.apache.ibatis.annotations.Select;
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
     * @param name 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.User>
     * @version: 1.0.0
     */
    @Select( "select * from be_user m where m.sys005='1' and name like '%${name}%'")
    List<User> listUser(UserQo qo);

}
